package com.endava.models;

import java.util.List;

public class Student extends User{

    public Major[] getMajors() {
        return majors;
    }

    private Major[] majors;

    public Student(String name, Gender gender, int age, Major...majors) {
        super(name, gender, age);
        this.majors = majors;
    }
}
