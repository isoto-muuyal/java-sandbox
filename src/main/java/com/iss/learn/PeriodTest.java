package com.iss.learn;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PeriodTest {


    public static void main(String[] args) {

        Period period = Period.of(1, 5, 2001);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());

        StringBuffer sb = new StringBuffer("days  " ).append(period.getDays());
        sb.append(" months ").append(period.getMonths());
        sb.insert(19, " inserted line");
        System.out.println("-----------------");
        System.out.println(sb);
        System.out.println("-----------------");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("E", Locale.US);
        System.out.println(pattern.format(LocalDate.of(2020,10,24)));

//        try {
            int value = 1;
            assert ++value > 1 : value;
            System.out.println(value);

            int val = 10;
            assert val >= 0 : "Value should be non-negative";
            System.out.println("Value is: " + val);

            int age = 15;
            assert age >= 18 : "Age should be 18 or older"; // This assertion will fail and throw an AssertionError
            System.out.println("Age is: " + age);
//        } catch (AssertionError ae) {
//            System.out.println("assertion error found: " + ae.getMessage() + "-" + ae.getLocalizedMessage());
//        }

    }

}
