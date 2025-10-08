package com;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private StudentService studentService;
    public Menu() {
        studentService = new StudentService();
    }
    public void displayMenu() {
        List<String> options = new ArrayList<>();
        options.add("Add Student from the beginning");
        options.add("Add Student from the end");
        options.add("Add Student at a specific location");
        options.add("Get the size of the queue");
        options.add("Get the first Student in the queue");
        options.add("Get the last Student in the queue");
        options.add("Get Student at a specific location");
        options.add("Delete the first Student in the queue");
        options.add("Delete the last Student in the queue");
        options.add("Delete Student at a specific location");
        final String header = MenuUtils.getHeader("------Student queue management menu------", options);
        while(true) {
            System.out.println(header);
            switch(InputManager.getNextInt()){
                case 1:{
                    String lastName = InputManager.getNextLine();
                    String firstName = InputManager.getNextLine();
                    String groupNumber = InputManager.getNextLine();
                    Student student = new Student(lastName, firstName, groupNumber);
                    studentService.addStudentFirst(student);
                    break;
                }
                case 2:{
                    String lastName = InputManager.getNextLine();
                    String firstName = InputManager.getNextLine();
                    String groupNumber = InputManager.getNextLine();
                    Student student = new Student(lastName, firstName, groupNumber);
                    studentService.addStudentLast(student);
                    break;
                }
                case 3:{
                    String lastName = InputManager.getNextLine();
                    String firstName = InputManager.getNextLine();
                    String groupNumber = InputManager.getNextLine();
                    Student student = new Student(lastName, firstName, groupNumber);
                    studentService.addStudentByIndex(student, InputManager.getNextInt());
                    break;
                }
                case 4:{
                    System.out.println(studentService.getSize());
                    break;
                }
                case 5:{
                    System.out.println(studentService.getFirstStudent());
                    break;
                }
                case 6:{
                    System.out.println(studentService.getLastStudent());
                    break;
                }
                case 7:{
                    System.out.println(studentService.getStudentByIndex(InputManager.getNextInt()));
                    break;
                }
                case 8:{
                    studentService.removeFirstStudent();
                    break;
                }
                case 9:{
                    studentService.removeLastStudent();
                    break;
                }
                case 10:{
                    studentService.removeStudentByIndex(InputManager.getNextInt());
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Invalid option");
                    break;
                }
            }
        }
    }
}
