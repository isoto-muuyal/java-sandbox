package com.iss.learn.hackerranck;

public class Student {

    private int id;
    private String name;
    private Double cgpa;

    public Student(int id, String name, Double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "[Student information: id " + getId() + ", name: " + getName() +
                ", cgpa: " + getCgpa() + "]";
    }
}
