package com.endava.models;

import java.util.List;

public class Student extends User{

    private Major major;

    public Student(String name, Gender gender, int age, Major major) {
        super(name, gender, age);
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return  "Student{" +"name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", major=" + major.getName() +
                ", score=" + major.getScore() +
                ", age=" + age +
                '}';
    }
}
