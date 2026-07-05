package com.iss.learn.records;

public interface Citizen {

    String country = "not defined";
    String passport = "na";

    String getCountry();

    void setCountry(String country) ;

    String getPassport();

    void setPassport(String passport);
}
