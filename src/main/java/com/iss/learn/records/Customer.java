package com.iss.learn.records;

public interface Customer {

    String name = "new";

    default String getMayusName() {
        return this.name.toUpperCase();
    }
    
}
