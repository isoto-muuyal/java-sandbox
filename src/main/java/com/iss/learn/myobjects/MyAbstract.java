package com.iss.learn.myobjects;

public abstract class MyAbstract {

    String name;

    String getName() {
        return name;
    }

    String setName(String name) {
        return this.name = name;
    }

    public abstract void printName();
}
