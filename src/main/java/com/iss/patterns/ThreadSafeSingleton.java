package com.iss.patterns;

public class ThreadSafeSingleton {

    private ThreadSafeSingleton(){

    }

    private static class Holder {
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public void doSomething() {
        System.out.println("The thread safe singleton doing something.");
    }
}
