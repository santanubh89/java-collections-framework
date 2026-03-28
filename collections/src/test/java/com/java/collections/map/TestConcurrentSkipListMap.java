package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListMap;

@Slf4j
public class TestConcurrentSkipListMap {

    @Test
    public void testConcurrentSkipListMap() {
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(3, "Three");
        skipListMap.put(1, "One");
        skipListMap.put(4, "Four");
        skipListMap.put(2, "Two");
        log.info("ConcurrentSkipListMap after additions: {}", skipListMap);

        String removedValue = skipListMap.remove(2);
        log.info("Removed value for key 2: {}, Current Map: {}", removedValue, skipListMap);

        String value = skipListMap.get(3);
        log.info("Value for key 3: {}", value);

        skipListMap.putIfAbsent(5, "Five");
        log.info("ConcurrentSkipListMap after putIfAbsent(5, 'Five'): {}", skipListMap);

        skipListMap.replace(1, "One", "Uno");
    }

    @Test
    public void testConcurrentAccess() {
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();

        Runnable writerTask = () -> {
            for (int i = 0; i < 100; i++) {
                skipListMap.put(i, "Value" + i);
            }
        };

        Runnable readerTask = () -> {
            for (int i = 0; i < 100; i++) {
                String value = skipListMap.get(i);
                if (value != null) {
                    log.info("Read key {}: {}", i, value);
                }
            }
        };

        Thread writerThread = new Thread(writerTask);
        Thread readerThread = new Thread(readerTask);

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }

        log.info("Final Size of ConcurrentSkipListMap: {}", skipListMap.size());
    }

    @Test
    public void testNavigationMethods() {
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(10, "Ten");
        skipListMap.put(20, "Twenty");
        skipListMap.put(30, "Thirty");
        skipListMap.put(40, "Forty");

        log.info("Original Map: {}", skipListMap);

        Integer firstKey = skipListMap.firstKey();
        Integer lastKey = skipListMap.lastKey();
        log.info("First Key: {}, Last Key: {}", firstKey, lastKey);

        Integer lowerKey = skipListMap.lowerKey(25);
        Integer higherKey = skipListMap.higherKey(25);
        log.info("Lower Key than 25: {}, Higher Key than 25: {}", lowerKey, higherKey);

        log.info("SubMap (15 to 35): {}", skipListMap.subMap(15, 35));
    }

}
