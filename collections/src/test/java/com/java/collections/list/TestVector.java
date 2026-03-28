package com.java.collections.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;

@Slf4j
public class TestVector {

    @Test
    public void testVector() {
        List<Integer> data = List.of(5, 1, 9, 7, 3, 0);
        Vector<Integer> vector = new Vector<>(8, 16);

        int capacity = vector.capacity();
        log.info("Initial Capacity: {}", capacity); // 8

        vector.addAll(data);
        capacity = vector.capacity();
        log.info("Current Capacity (6 first elements): {}", capacity); // 8

        vector.addAll(data);
        capacity = vector.capacity();
        log.info("Current Capacity (6 more elements): {}", capacity); // 24
    }

    @Test
    public void testVectorSynchronization() {
        List<Integer> vector = new Vector<>();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {

        }
        log.info("Vector Size after concurrent additions: {}", vector.size()); // Should be 2000
    }

}
