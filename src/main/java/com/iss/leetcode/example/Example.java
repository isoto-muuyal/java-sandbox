package com.iss.leetcode.example;

import com.iss.MyEnums.Status;
import com.iss.pojos.MyObj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {

    public static void main(String[] args) {

        System.out.println("test to identify if the mulfiply of all members of an array is positve negative or zero");
        int[] testValues = {1, 4, 1, 1};
        int val = isSumPositive(testValues);
        System.out.println("array: " + testValues.toString() + ", result: " + val);
        System.out.println("------------------------------");

        Set<Integer> myInts = Arrays.stream(testValues).boxed().collect(Collectors.toSet());
        List<Integer> sortedInts = myInts.stream().sorted(Comparator.comparingInt(Integer::intValue)).toList();

        String hola = "hola";
        StringBuilder hola2 = new StringBuilder("hola");
        IntStream codepoints = hola2.codePoints();
        codepoints.forEach(System.out::println);
        StringBuffer hola3 = new StringBuffer("hola");

        System.out.println(hola + " " +  hola2 + " " + hola3);

        StringBuilder hola4 = new StringBuilder(hola);
        StringBuffer hola5= new StringBuffer(hola4);
        String hola6 = hola;
        hola4.reverse();
        hola = "que onda";
        System.out.println(hola + " " + hola4 + " " + hola5 + " " + hola6);

        Integer a = 1;
        Integer b = a;
        System.out.println(a + " " + b);
        a = 5;
        System.out.println(a + " " + b);


        System.out.println("------------------------------");

        System.out.println("Identify the index of the first character that is not repeated in a string");
        int res = solutionNonRepeatedIndex("H eoolah");
        System.out.println("result: "  + res);
        System.out.println("------------------------------");

        System.out.println(Status.FINISHED);
        String fin = Status.FINISHED.toString();

        MyObj obj1 = new MyObj();
        System.out.println("------------------------------");
        System.out.println(obj1);
        System.out.println("------------------------------");
        testStatus(obj1);
        System.out.println(obj1);
        System.out.println("------------------------------");
    }

    public static void testStatus(MyObj obj) {
        obj.setStatus("updated");
        System.out.println("just testing");
    }

    private static int isSumPositive(int[] arr) {
        int res = 1;

        //is there any 0?
        for (int j : arr) {
            if (j == 0) {
                return 0;
            }
        }

        //is it negative?
        for (int i : arr){
            if (i < 0) {
                res = res * -1;
            }
        }

        return res;
    }

    private static int solutionNonRepeatedIndex(String S) {
        int[] count = new int[26];

        S = S.toLowerCase();
        S = S.trim().replace(" ", "");
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[S.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    private void testMultithread() {

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

        } catch (Exception e) {
            System.out.println("something happened: " + e.getMessage());
        }

    }

}
