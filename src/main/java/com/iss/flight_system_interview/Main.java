package com.iss.flight_system_interview;

import com.iss.flight_system_interview.records.Flight;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Flight> totalFlights =  List.of(
            new Flight("AN211", 100.00, 200.01, true),
            new Flight("AN211", 80.22, 300.01, true),
            new Flight("AN211", 100.55, 201.01, true),
            new Flight("AN211", 10.10, 440.01, false),
            new Flight("AN211", 130.40, 540.01, false),
            new Flight("AN211", 10.00, 20.11, true),
            new Flight("AN211", 1010.00, 2000.88, false)
    );

    private static FlightUtiil flightUtiil = new FlightUtiil();

    public static void main(String[] args) {
        List<Flight> availableFlights = flightUtiil.getFlightsWithAvailableSeats(totalFlights);
    }

}
