package com.java.collections.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

@Slf4j
public class TestLinkedList {

    LinkedList<Integer> linkedList = null;

    @BeforeEach
    public void setup() {
        linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(3);
    }

    @Test
    @DisplayName("Add - Adds elements to the LinkedList")
    public void add() {
        linkedList.addFirst(0);
        linkedList.addLast(8);
        log.info("LinkedList after additions: {}", linkedList);
    }

    @Test
    @DisplayName("Offer - Adds elements to the LinkedList")
    public void offer() {
        linkedList.offerFirst(0);
        linkedList.offerLast(8);
        log.info("LinkedList after offer: {}", linkedList);
    }

    @Test
    @DisplayName("Remove - Removes elements from the LinkedList")
    public void remove() {
        Integer remove = linkedList.remove();
        log.info("LinkedList after remove(): {}, removed element: {}", linkedList, remove);

        Integer first = linkedList.removeFirst();
        log.info("LinkedList after removeFirst(): {}, removed element: {}", linkedList, first);

        Integer last = linkedList.removeLast();
        log.info("LinkedList after removeLast(): {}, removed element: {}", linkedList, last);

        boolean removed = linkedList.removeIf(x -> x % 2 != 0);// Remove even numbers
        log.info("LinkedList after removeIf(): {}, removed element: {}", linkedList, removed);
    }

    @Test
    @DisplayName("Get - Gets the element of the LinkedList without removing it")
    public void get() {
        Integer get = linkedList.get(3);
        Integer first = linkedList.getFirst();
        Integer last = linkedList.getLast();
        log.info("LinkedList: {}, get: {}, first: {}, Last: {}", linkedList, get, first, last);
    }

    @Test
    @DisplayName("Peek - Gets the element of the LinkedList without removing it")
    public void peek() {
        Integer peek = linkedList.peek();
        Integer first = linkedList.peekFirst();
        Integer last = linkedList.peekLast();
        log.info("LinkedList: {}, peek: {}, first: {}, Last: {}", linkedList, peek, first, last);
    }

    @Test
    @DisplayName("Poll - Gets and removes the first element of the LinkedList")
    public void poll() {
        Integer poll = linkedList.poll();
        Integer first = linkedList.pollFirst();
        Integer last = linkedList.pollLast();
        log.info("LinkedList: {}, poll: {}, first: {}, Last: {}", linkedList, poll, first, last);
    }



}
