package com.java.collections.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
public class TestCopyOnWriteArraySet {

    @Test
    public void testCopyOnWriteArraySet() {
        CopyOnWriteArraySet<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        // Adding elements
        for (int i = 1; i <= 5; i++) {
            copyOnWriteSet.add(i);
            concurrentSkipListSet.add(i);
        }

        log.info("Initial CopyOnWriteArraySet: {}", copyOnWriteSet);
        log.info("Initial ConcurrentSkipListSet: {}", concurrentSkipListSet);

        for (int n : copyOnWriteSet) {
            log.info("Element from copyOnWriteSet: {}", n);
            copyOnWriteSet.add(6); // This will not affect the current iteration
        }
        log.info("Final CopyOnWriteArraySet: {}", copyOnWriteSet);

        for (int n : concurrentSkipListSet) {
            log.info("Element from concurrentSkipListSet: {}", n);
            concurrentSkipListSet.add(6);
        }
        log.info("Final ConcurrentSkipListSet: {}", concurrentSkipListSet);


    }

}
