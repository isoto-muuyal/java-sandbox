package com.iss.learn.records;

public interface Citizen {

    static String country = "not defined";
    static String passport = "na";

    public String getCountry();

    public void setCountry(String country) ;

    public String getPassport();

    public void setPassport(String passport);
}
