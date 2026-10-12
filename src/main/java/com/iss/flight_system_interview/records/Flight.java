package com.iss.flight_system_interview.records;

public record Flight(String name, Double fare, Double fullFare, Boolean availability) {

    public Double getDiscount(){
        return (fullFare * fare) /  fullFare;
    }


}
