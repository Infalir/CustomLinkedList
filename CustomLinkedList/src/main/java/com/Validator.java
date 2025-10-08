package com;

public class Validator {

    public boolean isValid(Student student) {
        return isNameValid(student.getFirstName()) &&
                isNameValid(student.getLastName())
                && isGroupNumberValid(student.getGroup());
    }

    public boolean isNameValid(String name){
        return name != null && !name.trim().isEmpty();
    }

    public boolean isGroupNumberValid(String groupNumber){
        return groupNumber != null && groupNumber.matches("\\d{6}");
    }
}
