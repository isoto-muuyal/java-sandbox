package com.iss.arenas;

import java.lang.foreign.Arena;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 * This class will help me understand better how Arenas and MemorySegment works.
 */
public class ArenasTest {

    //open confined arena
    public static void main(String[] args) {
        try  {
            Arena arena = Arena.ofConfined();
            int elements = 5;

            //allocate native memory
            MemorySegment intArray = arena.allocate(ValueLayout.JAVA_INT, elements);

            //write data into memory
            for (int i = 0 ; i < elements; i++) {
                intArray.setAtIndex(ValueLayout.JAVA_INT, i, (i * 8));
            }

            //read data from segment
            System.out.println("getting third element: " + intArray.getAtIndex(ValueLayout.JAVA_INT, 2));
            System.out.println(arena.scope().toString());
            arena.close();
            System.out.println("after arena.close");
            arena.close();
        } catch (Exception e) {
            System.out.println("exception happened: " + e.getMessage());
        }

    }
}
