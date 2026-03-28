package com.java.collections.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Slf4j
public class TestLinkedListAsQueue {

    @Test
    public void testLinkedListAsQueue() {
        LinkedList<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        queue.add(6);
        queue.offerLast(7);
        queue.removeFirst(); // 1
        queue.pollFirst(); // 2
        var currentHead = queue.peek();
        log.info("Queue after operations: {}, current head: {}", queue, currentHead); // Should print [3, 4, 5, 6, 7]
    }

    @Test
    public void testQueue() {
        Queue<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        queue.add(6);
        queue.offer(7);
        queue.remove(); // 1
        queue.poll(); // 2
        var currentHead = queue.element();
        log.info("Queue after operations: {}, current head: {}", queue, currentHead); // Should print [3, 4, 5, 6, 7]
    }

    @Test
    public void testQueueOperations() {
        Queue<Integer> queue = new LinkedList<>(List.of(1, 2));
        log.info("queue.remove():: {}", queue.remove()); // 1
        log.info("queue.poll():: {}", queue.poll());   // 2
        Integer currentHead = queue.peek();
        log.info("Queue after operations: {}, current head: {}", queue, currentHead);
        log.info("queue.poll():: {}", queue.poll()); // Does not throw exception
         // Now queue is empty
         // Testing exception throwing methods
        try {
            queue.remove();
        } catch (Exception e) {
            log.error("remove() throws exception if queue is empty: {}", e.getMessage());
        }
        try {
            currentHead = queue.element();
        } catch (Exception e) {
            log.error("element() throws exception if queue is empty: {}", e.getMessage());
        }

        queue = new ArrayBlockingQueue<>(2);
        log.info("add 1::{}", queue.add(1));
        log.info("offer 2::{}", queue.offer(2));
        log.info("offer 3::{}", queue.offer(3));
        try {
            log.info("add 4::{}", queue.add(4)); // This will throw IllegalStateException
        } catch (Exception e) {
            log.error("add() throws exception if queue is full: {}", e.getMessage());
        }
        log.info("Final Queue state: {}", queue);
    }

}
