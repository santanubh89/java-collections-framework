package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class TestConcurrentHashMap {

    @Test
    public void testConcurrentHashMap() {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Value" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Value" + i);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }
        log.info("HashMap Size after concurrent modifications: {}", map.size()); // May be less than 2000

    }
}
