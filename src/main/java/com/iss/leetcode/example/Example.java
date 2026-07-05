package com.iss.leetcode.example;

import com.iss.pojos.MyObj;

public class Example {

    public static void main(String[] args) {
        MyObj obj1 = new MyObj();
        System.out.println("------------------------------");
        System.out.println(obj1);
        System.out.println("------------------------------");
        testStatus(obj1);
        System.out.println(obj1);
        System.out.println("------------------------------");
    }

    public static void testStatus(MyObj obj) {
        obj.setStatus("updated");
        System.out.println("just testing");
    }
}
