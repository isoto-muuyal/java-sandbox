package com.iss.learn.hackerrange;

import com.iss.learn.annotationExercise.FamilyBudget;
import com.iss.learn.annotationExercise.MyAnnotation;

import java.util.ArrayList;
import java.util.List;

public class Result {


    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> res = new ArrayList<>();

        // first move the right to left
        for (int i = 0 ; i < a.size() ; i ++) {
            if ( (i + d) < a.size()) {
                res.add(a.get(i + d));
            }
        }

        //move first from left to right
        for (int i = 0 ; i < d ; i++) {
            res.add(a.get(i));
        }

        return res;
    }


    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        // counter of swaos
        int counter = 0;

        for (int i = 1 ; i <= arr.length ; i ++) {
            if (!isInPlace(i, arr[i])) {

                //get values
                int curr = arr[i-1];
                int tmpIndex = getCorrectIndex(i, arr); //arr[curr - 1];
                int correct = arr[tmpIndex];

                //swap
                arr[i] = correct;
                arr[tmpIndex] = curr;
                counter++;
            }
        }

        return counter;
    }

    private static int getCorrectIndex(int i, int[] arr) {
        for (int n = 0 ; n <= arr.length ; n++) {
            if (arr[n ] == i) {
                return n;
            }
        }
        return -1;
    }

    private static boolean isInPlace(int index, int value) {
        return index + 1 == value ? true : false;
    }

    private static int lastSorted(int[] arr) {
        int n = 0;
        for (int i = 0 ; i < arr.length - 1 ; i ++) {
            if (arr[i] < arr[i+1]) {
                n++;
            } else {
                break;
            }
        }
        return n;
    }

    private static void test() {
        System.out.println((new String()).length());
        final int b;
        int arr[][] = new int[2][]; // Line 1

        int i='A';
        double d=2e2;
        char c=32;
        long l=5^2;
        if(i<d && d>c || i>l && i>c || c>l)
            System.out.println(c/l);
        else
            System.out.println(l/c);
    }

}
