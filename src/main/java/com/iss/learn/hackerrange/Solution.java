package com.iss.learn.hackerrange;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
    public static void main(String[] args) {

        List<Integer> ar = Arrays.asList(1, 2, 3, 4, 5);
        long res = 0;

        res = Long.valueOf(ar.stream().reduce(0, (a,b) -> a + b));

        System.out.println(res);

        StringBuilder s = new StringBuilder("API");
        String st = s.reverse().toString();
        printallCombinations(st, "");
        StringBuilder replacedString = new StringBuilder(st);
        for (int i = 0; i < replacedString.length(); i++) {
            if (replacedString.charAt(i) == 'P')
                replacedString.setCharAt(i, 'p');
        }
        char[] charArray = new char[s.length()];
        s.getChars(0, s.length(), charArray, 0);
        System.out.println("Character Array value: "+Arrays.toString(charArray));
    }
    static void printallCombinations(String str, String str2) {
        if (str.length() == 0) {
            System.out.print(str2 + " "); return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String str3 = str.substring(0, i) + str.substring(i + 1);
            printallCombinations(str3, str2 + ch);
        }
    }

}
