package com.iss.learn.enums;

import com.iss.learn.myobjects.BookRecord;

public enum MyEnum {

    AB(new BookRecord(1, "ab")),
    AC(new BookRecord(2, "ac")),
    AD(new BookRecord(2, "ad"));

    BookRecord book;

    MyEnum(BookRecord b) {
        book = b;
    }

    public BookRecord getBook() {
        return this.book;
    }
}
