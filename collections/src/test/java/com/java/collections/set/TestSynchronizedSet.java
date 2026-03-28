package com.java.collections.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
public class TestSynchronizedSet {

    @Test
    public void testSynchronizedSet() {
        Set<String> set = Set.of("A", "B", "C", "D", "E");
        Set<String> synchronizedSet = Collections.synchronizedSet(set);
        log.info("Synchronized Set elements: {} {}", synchronizedSet.getClass(), synchronizedSet);
    }

    @Test
    public void testConcurrentSkipListSet() {
        ConcurrentSkipListSet<String> concurrentSet = new ConcurrentSkipListSet<>();
        concurrentSet.add("A");
        concurrentSet.add("B");
        concurrentSet.add("C");
        log.info("ConcurrentSkipListSet elements: {} {}", concurrentSet.getClass(), concurrentSet);
    }


}
