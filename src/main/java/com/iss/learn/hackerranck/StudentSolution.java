package com.iss.learn.hackerranck;

import java.util.Comparator;
import java.util.List;

public class StudentSolution {

    public static void main(String[] args) {

        List<Student> students = new java.util.ArrayList<>(List.of(new Student(1, "john", 44.2),
                new Student(2, "Mike", 33.1),
                new Student(3, "Juan", 50.0D),
                new Student(4, "Miguel", 30.5D),
                new Student(5, "Pepe", 28.2)));

        students.sort(Comparator.comparingDouble(Student::getCgpa)
                .reversed()
                .thenComparing(Student::getName));

        students.forEach(System.out::println);
    }

}
