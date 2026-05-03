package com.iss.learn.hackerranck;

import com.iss.learn.enums.MyEnum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MinMaxSum {

    private static BigInteger sumMin(List<Integer> list) {

        //get largest number
        Integer max = 0;
        for (Integer el : list) {
            if (el < max){
                System.out.println("found next largest: " + el);
                max = el;
            }
        }

        List<MyEnum> listOfEnums = new ArrayList<>();


        //sum all numbers but the largest one
        BigInteger res = BigInteger.ZERO;
        for(Integer el : list) {
            if (!Objects.equals(el, max)) {
                res = res.add(BigInteger.valueOf(el));
            }
        }

        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {

        List<Integer> myList = List.of(4, 5, 9, 10, 3);

        //calculate min

    }

}
