package com.iss.patterns;

public class Singleton {

    private final Integer id;
    private final String name;
    private static Singleton instance;

    private Singleton() {
        this.id = 10;
        this.name = "my name loaded from db";
    }

    private static Singleton getInstance() {
        if ( instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private void sayHello() {
        System.out.println("Hello form singleton.");
    }

}
