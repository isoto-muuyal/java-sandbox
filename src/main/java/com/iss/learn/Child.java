package com.iss.learn;

public class Child  extends  Parent{
    static {
        System.out.println("3");
    }

    Child() {
        System.out.println("4");
    }
}
