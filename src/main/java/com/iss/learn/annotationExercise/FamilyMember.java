package com.iss.learn.annotationExercise;

import java.lang.annotation.*;


class FamilyMember {

    @FamilyBudget( userRole = "Senior", budget = 1000)
    public void getSeniorMember(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget( userRole = "Junior", budget = 200)
    @MyAnnotation(valor = Valores.DOS)
    public void getJuniorUser(int budget, int moneySpend) {
        System.out.println("Junior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget( userRole = "Senior", budget = 500)
    public void getSeniorMember2(int budget, int moneySpend) {
        System.out.println("Senior Member");
        System.out.println("Spend: " + moneySpend);
        System.out.println("Budget Left: " + (budget - moneySpend));
    }
}




