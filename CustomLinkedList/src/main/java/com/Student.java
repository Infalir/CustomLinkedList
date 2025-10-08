package com;

import lombok.Data;

@Data
public class Student {
    private String lastName;
    private String firstName;
    private String group;
    public Student() {}
    public Student(String lastName, String firstName, String group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
    }
}
