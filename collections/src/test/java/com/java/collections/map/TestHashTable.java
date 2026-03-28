package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

@Slf4j
public class TestHashTable {

    @Test
    public void testHashTable() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");
        log.info("Hashtable: {}", hashtable);
        log.info("Value for key 2: {}", hashtable.get(2));
        // hashtable.put(null, "NullKey"); // This will throw NullPointerException
        // hashtable.put(4, null); // This will also throw NullPointerException
    }

    @Test
    public void testHashTableConcurrency() throws InterruptedException {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashtable.put(i, i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                hashtable.put(i, i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("Hashtable size after concurrent modifications: {}", hashtable.size());
    }

}
