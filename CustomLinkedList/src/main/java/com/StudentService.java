package com;

import java.util.LinkedList;

public class StudentService {
    private MyLinkedList<Student> queue = new MyLinkedList<>();
    private Validator validator = new Validator();
    public StudentService() {
        Student s1 = new Student("Ivan", "Ivanov", "324402");
        Student s2 = new Student("Anna", "Malikova", "324403");
        Student s3 = new Student("Sophia", "Svenira", "324401");
        queue.addFirst(s1);
        queue.addFirst(s2);
        queue.addFirst(s3);
    }

    public int getSize(){
        return queue.size();
    }

    public void addStudentFirst(Student student){
        if (validator.isValid(student)){
            queue.addFirst(student);
        }
        else {
            throw new IllegalArgumentException("Invalid Student");
        }
    }

    public void addStudentLast(Student student){
        if (validator.isValid(student)){
            queue.addLast(student);
        }
        else {
            throw new IllegalArgumentException("Invalid Student");
        }
    }

    public void addStudentByIndex(Student student, int index){
        if (validator.isValid(student)){
            queue.add(index, student);
        }
        else {
            throw new IllegalArgumentException("Invalid Student");
        }
    }

    public Student getFirstStudent() {
        return queue.getFirst();
    }

    public Student getLastStudent() {
        return queue.getLast();
    }

    public Student getStudentByIndex(int index) {
        return queue.get(index);
    }

    public Student removeFirstStudent() {
        return queue.removeFirst();
    }

    public Student removeLastStudent() {
        return queue.removeLast();
    }

    public Student removeStudentByIndex(int index) {
        return queue.remove(index);
    }

}
