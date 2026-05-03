package com.iss.learn.certs;

public class River {
    static int i = demo();
    static {
        System.out.print(i);// line 1
    }

    public River() {
        System.out.print("hello");
    }

    public static void main(String[] args) {
        new River();
        System.out.println("Hello");
    }

    static int demo() {
        System.out.print("Inside Demo");
        return 10;
    }

}
