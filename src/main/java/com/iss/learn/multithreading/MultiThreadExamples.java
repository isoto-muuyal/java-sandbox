package com.iss.learn.multithreading;

import java.time.Duration;

public class MultiThreadExamples {

    public static void main(String[] args) throws InterruptedException {
        MyTask1 task1 = new MyTask1();
        MyTask2 task2 = new MyTask2();

        Thread threadTask1 = new Thread(task1);
        Thread threadTask2 = new Thread(task2);

        task1.run();
        task2.run();

        threadTask1.start();
        System.out.println("State1 " + threadTask1.getState());
        System.out.println("name1 " + threadTask1.getName());

        threadTask2.start();
        System.out.println("State1 " + threadTask1.getState());
        System.out.println("name1 " + threadTask1.getName());
        System.out.println("State2 " + threadTask2.getState());
        System.out.println("name2 " + threadTask2.getName());

        threadTask1.setName("MyThread1Renamed");
        System.out.println("name1 " + threadTask1.getName());

        threadTask1.join(Duration.ofMillis(1000));

    }

}
