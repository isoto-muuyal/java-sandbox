package com.iss.learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.BiPredicate;

public class LambdasLearning {

    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<>(List.of("abc1234", "bcde1", "cdef55"));
        list.forEach(System.out::println);
        List<? super Integer> longitudes = list.stream().map(String::length).toList();
        System.out.println(longitudes);
        longitudes.forEach(System.out::println);
        System.out.println("-------------------");
        list.sort((a, b) -> b.length() - a.length());
        list.forEach(System.out::println);
        list.stream().map(String::length).forEach(System.out::println);

        Stream<Integer> generate = Stream.generate(() -> (int) (Math.random() * 5 + 1));
        System.out.println(generate.limit(5).collect(Collectors.toList()));

        BiPredicate<String, Integer> myBiPredicate = (a, b) -> a.length() > b;
        System.out.println("/r Bi predicate test: (a, b) -> a.length() > b;");
        System.out.println(myBiPredicate.test("abc", 3));

        System.out.println(9 % 2);
        System.out.println(4 % 2);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        System.out.println(mutableNumbers);
        mutableNumbers.removeIf(n -> n % 2 != 0);
        System.out.println(mutableNumbers);

        List<String> names = List.of("John", "Jane", "Jill", "Joe", "Jacqueline", "Joseph");
        System.out.println(names.stream().mapToInt(String::length).sum());

        //flat map example
        System.out.println("Flat map example");
        List<List<String>> arrayNames = Arrays.asList(names, Arrays.asList("John", "Janine"));
        System.out.println(arrayNames
                .stream()
                .flatMap(l -> l.stream().map(s -> s.length()))
                .filter(i -> i > 4)
                .count()
        );
        System.out.println(arrayNames);
        System.out.println(arrayNames.stream().flatMap(List::stream).collect(Collectors.toList()));

        arrayNames.stream().map(s -> s.stream().map(String::toUpperCase)).forEach(l -> l.forEach(System.out::println));
        arrayNames.stream().flatMap(List::stream).map(e -> e.toUpperCase()).forEach(System.out::println);

        Stream.of("a", "b23", "c1")
                .sorted(Comparator
                        .comparing(String::length)
                        .reversed())
                .forEach(System.out::println);

        System.out.println("-------- Filtering example -----");

        Stream<String> myStream = Stream.of("a54", "b456", "c133");
        myStream.filter(s -> {
            System.out.println("filtering");
            return s.length() > 3;
        }).forEach(System.out::println);

        System.out.println("-------- Mapping example -----");
        Stream<String> myStream2 = Stream.of("a54", "b456", "c133");
        myStream2.map(s ->
                        s.replaceAll("[A-Za-z]", ""))
                .map(Integer::valueOf)
                .forEach(e -> System.out.println("Value: " + e + " , of type: " + e.getClass().getName()));

        System.out.println("""
                
                -------- Peeking example ----- """);

        Stream<String> ids = Stream.of("g54", "e456", "df133");
        Stream<String> ids2 = Stream.of("f55", "q123", "p4433");
        ;
        ids.peek(s -> {
                    s = s.toUpperCase();
                    System.out.println("peeking at all: " + s);
                })
                .filter(s -> s.length() > 3)
                .peek(s -> s = s + "--")
                .forEach(System.out::println);

        System.out.println("------------------------------------");
        System.out.println("Total ids: " + ids2
                .peek(s -> {
                    s = s.toUpperCase();
                    System.out.println("peeking at all: " + s);
                })
                .filter(s -> s.length() > 3)
                .peek(s -> s = s + "--")
                .count());

        System.out.println("---------- Comparator example ----------");
        Stream<String> ids3 = Stream.of("q9999", "7777", "g54", "e456", "df133");
        Stream<String> ids4 = Stream.of("99999999l", "h876i", "f55", "1", "q123", "p4433", "o0", "99");
        ;

        System.out.println("-------- sorting by string length ------");
        ids3.sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        System.out.println("-------- sorting by integer value ------");
        ids4.sorted(Comparator.comparingInt(a -> Integer.parseInt(a.replaceAll("[A-Za-z]", "")))
        ).forEach(System.out::println);

        System.out.println("------------- Reduce example ----------------");
        Stream<String> ids5 = Stream.of("hola", "mundo", "del", "java", "stream");
        ids5
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .reduce((s1, s2) -> s1 + " " + s2)
                .ifPresent(System.out::println);

        System.out.println("--------------- Groupd example --------------");
        Stream<String> nombres = Stream.of("Juan", "Jose", "Pepe", "Mario", "Ivan", "Luis", "Ali", "Mae", "LS");
        Map<Integer, List<String>> personas = nombres.collect(Collectors.groupingBy( p -> p.length()));
        personas.forEach((k, v) -> {
            v = v.stream().map( s -> s.toUpperCase()).toList();
            System.out.println("Key: " + k + " , value: " + v);
        });

    }
}
