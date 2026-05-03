package com.iss.learn.interfaces;

public interface IntA {

    static int x = 0;

    static void mystatic() {
        System.out.println("mystatic method intB");
    }

    default void disp() {
        System.out.println("display default inIntB");
    }

}
