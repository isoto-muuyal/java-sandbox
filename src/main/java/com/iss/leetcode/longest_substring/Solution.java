package com.iss.leetcode.longest_substring;

import java.util.*;

import static com.iss.leetcode.helpers.ValidationHelper.isValid;
import static com.iss.leetcode.helpers.ValidationHelper.validate;
import static java.lang.System.exit;

public class Solution {

    public static void main(String[] args) {

        // create testing string
        String testValue = "debdb";

        // get the longest string
        int longestLength = lengthOfLongestSubstring(testValue);

        // print it
        System.out.println(longestLength);
    }

    private static int lengthOfLongestSubstring(String s) {
        return isValid(s) ? getLongest(s).length() : 0;
    }

    private static String getLongest(String val) {
        String longestString = "";
        String current = "";
        ArrayList<String> continousStringList = new ArrayList<>();
        int currentLongestLength = 0;
        //iterate
        for (int i = 0; i < val.length(); i++) {
            //does char exist in string
            if (!isPresent(current, val.charAt(i))) {
                System.out.println("is not present, adding to existing string: " + current);
                current += val.charAt(i);
                //is it end of string
                if ( current.length() > longestString.length()) {
                    longestString = current;
                    currentLongestLength = longestString.length();
                    continousStringList.add(longestString);
                }
            } else {

                if (current.length() > longestString.length()) {
                    longestString = current;
                    //current = "";
                }

                System.out.println("already exists, moving string to collection of long");
                continousStringList.add(longestString);
                System.out.println("updating maximum length from " + currentLongestLength + " to " + longestString.length());
                currentLongestLength = longestString.length();
                current = String.valueOf(val.charAt(i));
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("list: " + continousStringList);
        System.out.println("-------------------------------------------------");
        continousStringList.sort(Comparator.comparingInt(String::length));
        List<String> reversed = continousStringList.reversed();
        System.out.println("curret string: " + current);
        System.out.println("longest length: " + currentLongestLength);
        System.out.println("longest string: " + longestString);
        System.out.println("sorted list: " + continousStringList);
        System.out.println("reversed list: " + reversed);
        System.out.println("-------------------------------------------------");
        System.out.println("longest string: " + continousStringList.get(0));
        return continousStringList.getLast();
    }

    //method to try iteration
    private static boolean isPresent(String continousString, char character) {
        System.out.println("does " + character + " exist in " + continousString);
        return continousString.indexOf(character) > -1;
    }

}
