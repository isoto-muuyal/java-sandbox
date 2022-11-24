package org.iss.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Stream<String> myStream = Stream.of("hello", " ", "world", " this", " is", " my", " ", "first", " app");
        List<String> myArray = new ArrayList<String>();
        myArray.add("hello world");
        myArray.add(" ");
        myArray.add("This is");
        myArray.add(" my first app!!");

//        myStream.forEach( s -> System.out.print(s));
        System.out.println("");
        System.out.println(" --------------------- ");
        myStream.forEach(System.out::print);

        System.out.println("");
        System.out.println(" --------------------- ");

        myArray.stream().forEach(App::myFunc);
        myArray.stream().forEach(System.out::print);
    }

    static void myFunc(String val) {
        val.toUpperCase();
    }
}
