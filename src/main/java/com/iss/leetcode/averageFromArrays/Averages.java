package com.iss.leetcode.averageFromArrays;

import java.util.Arrays;

public class Averages {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double val1 = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + val1);

        int[] nums3 = {1, 1};
        int[] nums4 = {3, 4};

        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {1, 2};
        int[] nums6 = {3, 4};

        System.out.println("Median: " + findMedianSortedArrays(nums5, nums6));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // joint arrays
        int[] newNumsArray = joinArrays(nums1, nums2);

        //get median
        return getMedian(newNumsArray);
    }

    private static int[] joinArrays(int[] nums1, int[] nums2) {
        //create new array with the length
        int[] newNumsArray = new int[nums1.length + nums2.length];

        // instantiate new array;
        for (int num = 0 ; num < nums1.length ; num++) {
            newNumsArray[num] = nums1[num];
        }
        //join with second array
        System.arraycopy(nums2, 0, newNumsArray, nums1.length, nums2.length);
        //sort it
        Arrays.sort(newNumsArray);

        return newNumsArray;
    }

    private static double getMedian(int[] numsArray) {
        double total;

        if (numsArray.length % 2 == 0){
            total = (numsArray[(numsArray.length / 2) - 1] + numsArray[(numsArray.length / 2)]);
            return total / 2;
        } else {
            total = numsArray[ (numsArray.length / 2) ];
            return total;
        }
    }
}
