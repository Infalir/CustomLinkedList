package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        list = new MyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }

    @Test
    void testSize(){
        assertEquals(3, list.size());
    }

    @Test
    void testAddFirst(){
        list.addFirst(1);
        assertEquals(4, list.size());
        assertEquals(1, list.getFirst());
    }

    @Test
    void testAddFirstToEmptyList(){
        MyLinkedList<Integer> empty = new MyLinkedList<>();
        empty.addFirst(1);
        assertEquals(1, empty.size());
        assertEquals(1, empty.getFirst());
        assertEquals(1, empty.getLast());
    }

    @Test
    void testAddLast(){
        list.addLast(40);
        assertEquals(4, list.size());
        assertEquals(40, list.getLast());
    }

    @Test
    void testAddByIndex(){
        list.add(1, 15);
        assertEquals(4,list.size());
        assertEquals(15, list.get(1));
    }

    @Test
    void testAddByNegativeIndex(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 15));
    }

    @Test
    void testAddByOutOfBoundsIndex(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(6, 15));
    }

    @Test
    void testGetFirst(){
        assertEquals(10, list.getFirst());
    }

    @Test
    void testGetFirstOnEmptyList(){
        MyLinkedList<Integer> empty = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, empty::getFirst);
    }

    @Test
    void testGetLast(){
        assertEquals(30, list.getLast());
    }

    @Test
    void testGetLastOnEmptyList(){
        MyLinkedList<Integer> empty = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, empty::getLast);
    }

    @Test
    void testGetByIndex(){
        assertEquals(20, list.get(1));
    }

    @Test
    void testRemoveFirst(){
        Integer removed = list.removeFirst();
        assertEquals(10, removed);
        assertEquals(2, list.size());
        assertEquals(20, list.getFirst());
    }

    @Test
    void testRemoveLast(){
        Integer removed = list.removeLast();
        assertEquals(30, removed);
        assertEquals(2, list.size());
        assertEquals(20, list.getLast());
    }

    @Test
    void testRemoveByIndex(){
        Integer removed = list.remove(1);
        assertEquals(20, removed);
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    void doesntAllowToGetOutOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void doesntAllowRemovalFromAnEmptyList(){
        MyLinkedList<Integer> empty = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, empty::removeFirst);
    }
}