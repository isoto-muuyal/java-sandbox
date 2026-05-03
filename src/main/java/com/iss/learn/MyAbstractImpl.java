package com.iss.learn;

import com.iss.learn.myobjects.MyAbstract;

public class MyAbstractImpl extends MyAbstract {

    @Override
    public void printName() {
        System.out.println("From my class Implementation");
    }

    public static void main(String[] args) {
        MyAbstract myAbstract = new MyAbstractImpl();
        myAbstract.printName();
    }

}
