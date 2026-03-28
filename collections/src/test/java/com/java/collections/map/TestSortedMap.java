package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
public class TestSortedMap {

    private SortedMap<Integer, String> sortedMap = null;

    @BeforeEach
    public void createSortedMap() {
        sortedMap = new TreeMap<>();
        sortedMap.put(5, "Five");
        sortedMap.put(1, "One");
        sortedMap.put(9, "Nine");
        sortedMap.put(3, "Three");
        sortedMap.put(7, "Seven");
        sortedMap.put(4, "Four");
        sortedMap.put(0, "Zero");
        sortedMap.put(6, "Six");
        sortedMap.put(8, "Eight");
        sortedMap.put(2, "Two");
        log.info("SortedMap: {}", sortedMap);
    }

    @Test
    public void testFirstAndLastKey() {
        // First Key
        Integer firstKey = sortedMap.firstKey();
        log.info("First Key: {}", firstKey);

        // Last Key
        Integer lastKey = sortedMap.lastKey();
        log.info("Last Key: {}", lastKey);
    }

    @Test
    public void testSubMap() {
        // Head Map
        SortedMap<Integer, String> headMap = sortedMap.headMap(5);
        log.info("Head Map (keys < 5): {}", headMap);

        // Tail Map
        SortedMap<Integer, String> tailMap = sortedMap.tailMap(5);
        log.info("Tail Map (keys >= 5): {}", tailMap);

        // Sub Map
        SortedMap<Integer, String> subMap = sortedMap.subMap(3, 7);
        log.info("Sub Map (3 <= keys < 7): {}", subMap);
    }

    @Test
    public void testPolling() {
        Map.Entry<Integer, String> firstEntry = sortedMap.pollFirstEntry();
        log.info("Polled First Entry: {}, Current SortedMap: {}", firstEntry, sortedMap);

        Map.Entry<Integer, String> lastEntry = sortedMap.pollLastEntry();
        log.info("Polled Last Entry: {}, Current SortedMap: {}", lastEntry, sortedMap);
    }

    @Test
    public void testCustomComparator() {
        SortedMap<String, Integer> reverseSortedMap = new TreeMap<>((a, b) -> b.compareTo(a));
        reverseSortedMap.put("Five", 5);
        reverseSortedMap.put("One", 1);
        reverseSortedMap.put("Nine", 9);
        reverseSortedMap.put("Three", 3);
        reverseSortedMap.put("Seven", 7);
        log.info("Reverse SortedMap: {}", reverseSortedMap);
    }

    @Test
    public void testSortByValue() {
        sortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> log.info("Key: {}, Value: {}", entry.getKey(), entry.getValue()));
    }
}
