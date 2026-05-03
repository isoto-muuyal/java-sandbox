package com.iss.learn;

sealed class Employee permits PermanentEmployee {
    protected void displayEmployee() {
        System.out.println("Inside the com.iss.learn.Employee class");
    }
}

sealed class PermanentEmployee extends Employee permits TempContractor {
    void displayPermanentEmployee() {
        System.out.println("Inside the Permanent com.iss.learn.Employee class");
    }
}

non-sealed class TempContractor extends PermanentEmployee {
    void displayTempContractor(){
        System.out.println("Inside the TmpContractor");
    }
}

final class ContractEmployee extends TempContractor{
    void displayContractEmployee() {
        System.out.println("Inside the Contract com.iss.learn.Employee class");
    }
}

public class Main {

    public static void main(String[] args) {

        ContractEmployee ce = new ContractEmployee();
        ce.displayEmployee();
        ce.displayPermanentEmployee();
        ce.displayContractEmployee();
        ce.displayTempContractor();
    }

}