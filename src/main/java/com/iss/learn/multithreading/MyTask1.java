package com.iss.learn.multithreading;

public class MyTask1 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task1");
        } catch (InterruptedException e) {
            System.out.println("Exception found: " + e.getMessage());
        }
    }

}
