package com.iss.streamsAndCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsAndCollections {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "apple", "cherry", "bat", "date");

        Map<String, Long> result = words.stream()
                .filter(w -> w.length() > 3)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

}
