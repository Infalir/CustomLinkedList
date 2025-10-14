package com;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public int size() {
        return size;
    }
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node current = getNode(index);
        Node newNode = new Node(data);
        Node prev = current.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = current;
        current.prev = newNode;
        size++;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        else {
            tail = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        else {
            head = null;
        }
        size--;
        return data;
    }

    public T remove(int index) {
        Node target = getNode(index);
        T data = target.data;
        Node prev = target.prev;
        Node next = target.next;
        if (prev != null) {
            prev.next = next;
        }
        else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        else {
            tail = prev;
        }
        size--;
        return data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index < size / 2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }
        else {
            current = tail;
            for(int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }
}
