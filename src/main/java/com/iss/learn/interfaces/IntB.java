package com.iss.learn.interfaces;

import com.iss.learn.myobjects.Book;

public interface IntB {

    int x = 4;
    Book book1 = new Book();

    static void mystatic() {
        System.out.println("mystatic method IntA");
    }

    default void disp() {
        System.out.println("display default inIntA");
    }
}
