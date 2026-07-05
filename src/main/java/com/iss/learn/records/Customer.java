package com.iss.learn.records;

public interface Customer {

    String name = "new";

    default String getMayusName() {
        return name.toUpperCase();
    }
    
}
