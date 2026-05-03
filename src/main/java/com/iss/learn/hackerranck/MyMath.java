package com.iss.learn.hackerranck;

public class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    // Write your code here
    protected static PerformOperation isOdd() {
        return (n) -> (n % 2 != 0) || (n % 2 == 1);
    }

    protected PerformOperation isPrime() {
        return (n) -> {
            if ( n <= 1) {
                return false;
            } else if ( n == 2) {
                return true;
            } else if ( n > 2 && (n % 2 == 0)) {
                return false;
            } else {
                int limit = (int) Math.sqrt(n);
                int count = 0;
                for (int i = 3 ; i < limit ; i++) {
                    if ( n % i == 0 && n != i) {
                        count++;
                    }
                }
                if ( count > 2) {
                    return false;
                }
                return true;
            }
        };
    }

    protected PerformOperation isPalindrome() {
        return (n) -> {
            String origin = String.valueOf(n);
            System.out.println("origin: " + origin);
            String reverse = new StringBuilder(String.valueOf(n)).reverse().toString();
            return origin.equals(reverse);
        };
    }


}
