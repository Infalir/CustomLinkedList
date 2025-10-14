package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void testInvalidFirstName(){
        Student s = new Student("John", "", "123456");
        assertFalse(validator.isNameValid(s.getFirstName()));
    }

    @Test
    void testInvalidLastName(){
        Student s = new Student("  ", "Doe", "123456");
        assertFalse(validator.isNameValid(s.getLastName()));
    }

    @Test
    void testInvalidGroupNumberLetters(){
        Student s = new Student("John", "Doe", "1AB456");
        assertFalse(validator.isGroupNumberValid(s.getGroup()));
    }

    @Test
    void testInvalidGroupNumberLength(){
        Student s = new Student("John", "Doe", "12345678");
        assertFalse(validator.isGroupNumberValid(s.getGroup()));
    }

    @Test
    void testEmptyGroupNumber(){
        Student s = new Student("John", "Doe", null);
        assertFalse(validator.isGroupNumberValid(s.getGroup()));
    }

    @Test
    void passValidStudent(){
        Student s = new Student("John", "Doe", "123456");
        assertTrue(validator.isValid(s));
    }

}