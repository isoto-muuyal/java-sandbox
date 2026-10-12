package com.iss.flight_system_interview;

import com.iss.flight_system_interview.records.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightUtiil {

    public List<Flight> getFlightsWithAvailableSeats(List<Flight> flights){

        List<Flight> availableFlights = flights.parallelStream().filter(
                f -> {
                    boolean b = f.availability() && f.fare() == f.fullFare();
                    return b;
                }).collect(Collectors.toList()
        );
        return availableFlights;
    }

}
