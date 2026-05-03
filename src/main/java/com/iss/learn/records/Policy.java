package com.iss.learn.records;

import java.io.Serializable;

public record Policy(int policyNumber, String policyName,
                     long duration, double interestRate) implements Serializable {
}
