package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testRejectsInvalidStudentWhenAddingFirst(){
        Student invalid = new Student("", "Doe", "666");
        assertThrows(IllegalArgumentException.class, () -> studentService.addStudentFirst(invalid));
    }

    @Test
    void testRejectsInvalidStudentWhenAddingLast(){
        Student invalid = new Student("", "Doe", "666");
        assertThrows(IllegalArgumentException.class, () -> studentService.addStudentLast(invalid));
    }

    @Test
    void testRejectsInvalidStudentWhenAddingByIndex(){
        Student invalid = new Student("", "Doe", "666");
        assertThrows(IllegalArgumentException.class, () -> studentService.addStudentByIndex(invalid, 1));
    }
}