package com.iss.learn;

import com.iss.learn.records.ForeignCustomer;

import java.time.Instant;
import java.time.InstantSource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RecordTest {

    public static void main(String[] args) {
        ForeignCustomer foreignCustomer1 = new ForeignCustomer(1, "fname", "mayemail@gmail.com", "123 fake st", "Mx");
        ForeignCustomer foreignCustomer2 = new ForeignCustomer(1, "fnasdfme", "mayesdfmail@gmail.com", "123 fake st", "Canada");
        System.out.println(foreignCustomer1);

        System.out.println(foreignCustomer1.equals(foreignCustomer2));
        System.out.println(foreignCustomer1.getMayusName());
        System.out.println(foreignCustomer1.name());

        Instant i = InstantSource.system().instant();

        System.out.println(i);
        System.out.println(i.getEpochSecond());

        LocalDateTime fixedldt = LocalDateTime.of(2022, 1, 1, 0, 0);
        Instant i2 = InstantSource.fixed(fixedldt.toInstant(ZoneOffset.UTC)).instant();
        System.out.println(i2);
        System.out.println(i2.getEpochSecond());

        Instant i3 = i.plusSeconds(30000);

        System.out.println(i3);
        System.out.println(i3.getEpochSecond());

    }
}
