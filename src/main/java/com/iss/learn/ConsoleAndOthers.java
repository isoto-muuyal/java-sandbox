package com.iss.learn;

import java.io.Console;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConsoleAndOthers {

    public static void main(String[] args) {

        LocalTime tempTime = LocalTime.of(22, 15);
        System.out.println(tempTime);

        Console console = System.console();
        System.out.println("Enter");
        String myObject = "test";
        String user = console.readLine("your username: %s", myObject);
        System.out.println(user);

        ZonedDateTime tmp
                = ZonedDateTime.parse("2018-10-25T23:12:31.123+02:00[Europe/Paris]");

        System.out.println(tmp);
        System.out.println(ZoneId.from(tmp));
    }

}
