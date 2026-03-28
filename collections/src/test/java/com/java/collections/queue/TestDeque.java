package com.java.collections.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class TestDeque {

    @Test
    public void testDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        log.info("Deque after additions: {}", deque);
        log.info("Poll First: {}", deque.pollFirst());
        log.info("Poll Last: {}", deque.pollLast());
        log.info("Remove First: {}", deque.removeFirst());
        log.info("Deque after operations: {}", deque);

    }

}
