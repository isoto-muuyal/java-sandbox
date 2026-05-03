package com.iss.learn.infy;

import java.util.List;
import java.util.stream.IntStream;

public class Course {

    static int i = demo();
    static {
        System.out.print(i);// line 1
    }

    public Course() {
        System.out.print("hello");
    }

    public static void main(String[] args) {
        new Course();
        Course
                course
    = new Course(); System.out.println(course
     );

        System.out.println("Hello");
    }

    static int demo() {
        System.out.print("Inside Demo");
        return 10;
    }

    static void test() {

        final List<String> fruits =
                List.of("Orange", "Apple", "Lemon", "Raspberry");
        final List<String> types =
                List.of("Juice", "Pie", "Ice", "Tart");
        final var stream =
                IntStream.range(0, Math.min(fruits.size(), types.size()))
                        .mapToObj((i -> fruits.get(i) + " " + types.get(i)));
        stream.forEach(System.out::println);
    }

}
