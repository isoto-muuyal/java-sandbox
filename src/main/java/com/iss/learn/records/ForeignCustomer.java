package com.iss.learn.records;

public record ForeignCustomer(int id, String name, String email, String address, String country) implements Customer  {

    static int dpt;

    public ForeignCustomer {
        if (id <= 0) {
            throw new IllegalArgumentException("id cannot be 0 nor negative");
        }
        dpt = 1;
    }

    public boolean equals(ForeignCustomer c2) {
        return this.id == c2.id;
    }

    public String getMayusName() {
        return this.name.toUpperCase();
    }

}
