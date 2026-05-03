package com.iss.learn.service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsTests {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6);
        int result = numbers
                .stream()
                .reduce(0, Integer::sum, Integer::sum);
        System.out.println("-----------------------");
        System.out.println(result);
        System.out.println("-----------------------");
        List<List<Integer>> arr = List.of(List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9));

        arr.stream().map(l -> l.stream().reduce(0, Integer::sum)).forEach(System.out::println);

        Stream<Persona> personas = Stream.of(new Persona("Issac", 25, "test@gmail.com", true),
                new Persona("Juan", 19, "myemail@s.com", true),
                new Persona("Maria", 19, "myemail@s.com", false));

        Map<Integer, List<Persona>> personasByEdad = personas.collect(Collectors.groupingBy(Persona::age));
        System.out.println("--------------- Personas por edad ---------------");
        System.out.println(personasByEdad);

        Stream<Persona> personas2 = Stream.of(new Persona("Mario", 20, "sdf@gsd.com", true),
                new Persona("Jose", 20, "sdf@gsd.com", false), new Persona("Juan", 19, "sdf@gsd.com", true));
       personas2.collect(Collectors.groupingBy(Persona::age))
               .forEach((k, v) -> System.out.println("age: " + k + "persona(s): "
                       + v + ": promedio edad: "
                       + v.stream().mapToDouble(Persona::age).average().getAsDouble() ));


        Stream<Persona> personas3 = Stream.of(new Persona("Mario", 21, "sdf@gsd.com", true),
                new Persona("Jose", 18, "sdf@gsd.com", false), new Persona("Juan", 18, "sdf@gsd.com", true));

        System.out.println(personas3.collect(Collectors.averagingDouble(Persona::age)));

        flatMapping();

        paralelStreams();
    }

    public static void flatMapping() {
        System.out.println("------------------ flatMapping test ------------------");
        List<Integer> integerList = List.of(4, 3, 1, 5);

        System.out.println("Integer List - " + integerList);

        Stream<Integer> integerStream = integerList.stream();

        List<String> flattenedList = integerStream.collect(Collectors.flatMapping(e -> Stream.of("valor1 " + e + 1, "valor m1 " + (e - 1)),
                Collectors.toList()));

        System.out.println("Result of applying flatMapping method on the list - " + flattenedList);
    }

    public static void paralelStreams() {
        System.out.println("------------------ paralelStreams test ------------------");
        List<Integer> nums = List.of(4,3,8,6,1,9,11,16,15);
        Stream<Integer> intStream = nums.parallelStream();
        Stream<Integer> intStream2 = nums.parallelStream();
        Stream<Integer> intStream3 = nums.parallelStream();

        System.out.println("------------- Filter comparison ---------------");
        System.out.println(Instant.now());
        System.out.println(intStream.filter(e -> e % 2 == 0).collect(toList()));
        System.out.println(Instant.now());

        System.out.println(Instant.now());
        System.out.println(nums.stream().filter(e -> e % 2 == 0).collect(toList()));
        System.out.println(Instant.now());

        System.out.println("-------------- print comparison ---------------");
        System.out.println(Instant.now());
        intStream2.forEach(System.out::print);
        System.out.println();
        System.out.println(Instant.now());

        System.out.println(Instant.now());
        nums.stream().forEach(System.out::print);
        System.out.println();
        System.out.println(Instant.now());

        System.out.println("-------------- Sort comparison ---------------");
        System.out.println(Instant.now());
        System.out.println(intStream3.sorted().collect(toList()));
        System.out.println(Instant.now());

        System.out.println(Instant.now());
        System.out.println(nums.stream().sorted().collect(toList()));
        System.out.println(Instant.now());

    }

}
