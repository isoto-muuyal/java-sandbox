package com.iss.learn.aligner;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class SolutionInput {
        public List<Integer> nums;
        public int target;
    }

    public List<Integer> findIndices(SolutionInput arguments) {
        List<Integer> nums = arguments.nums;
        int target = arguments.target;

        // Your code here
        List<Integer> res = new ArrayList<>();
        int index1 = -1;
        int num1 = 0;
        int index2 = -1;
        int num2 = 0;
        boolean found = false;
        //loop
        for (int i = 0; i < nums.size() ; i++) {
            //validate it is smaller than target
            if (nums.get(i) < target ) {
                //get index and number
                if (index1 != -1) {
                    index1 = i;
                    num1 = nums.get(i);
                } else if (!found) {
                    index2 = i;
                    num2 = nums.get(i);
                }

                //compare if numbers are correct
                if ( (num1 + num2) == target ) {
                    res.add(index1);
                    res.add(index2);
                    break;
                }
            }
        }

        return res;
    }
}
