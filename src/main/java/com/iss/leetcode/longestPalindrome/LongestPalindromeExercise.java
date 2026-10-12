package com.iss.leetcode.longestPalindrome;

public class LongestPalindromeExercise {



    public static void main(String[] args) {
        String value = "xaabacxcabaaxcabaax";
        String palindrome = longestPalindrome(value);

        if (!palindrome.equals("")) {
            System.out.println("Longest palindrome in: " + value + ", is: " + palindrome);
        } else {
            System.out.println("no palindrome found in string");
        }

    }

    private static String longestPalindrome(String value) {
        String longestPalindrome = "";

        //scenario one letter only
        if (value.length() == 1 || onlyOneChar(value)){
            return value;
        }

        for (int i = 0 ; i < value.length() - 1 ; i ++) {

            //get palindrome
            String palindrome = getPossiblePalindrome(value, i);
            System.out.println("Palindrome found: " + palindrome);

            if (!palindrome.equals("") && palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }

    private static Boolean onlyOneChar(String value) {
        return value.replace(String.valueOf(value.charAt(0)), "").isEmpty();
    }

    private static String getPossiblePalindrome(String value, int i){
        String possiblePalindrome = "";
        boolean isEndOfString = false;
        char a = value.charAt(i);

        if (i < value.length()) {
            if (!isEndOfString) {
                int finalPos = value.substring(i + 1).indexOf(a) + i + 1;
                if (finalPos >= 0) {
                    String temp = value.substring(i, finalPos + 1);
                    String inverse = invertString(temp);
                    if (temp.equals(inverse)) {
                        System.out.println("Palindrom found!  " + possiblePalindrome);
                        possiblePalindrome = temp;
                    }
                }
            }
        }
        return possiblePalindrome;
    }

    private static String invertString(String value) {
        return new StringBuilder(value).reverse().toString();
    }

}
