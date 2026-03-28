package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestImmutableMap {

    @Test
    public void testCreateUnmodifiableMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);
        log.info("Unmodifiable Map: {} {}", unmodifiableMap.getClass(), unmodifiableMap);
        map.put(4, "Four");
        log.info("Original Map after modification: {}", map);
        log.info("Unmodifiable Map after original map modification: {}", unmodifiableMap);
    }

    @Test
    public void testImmutableMap() {
        var immutableMap = Map.of(
                "A", 1,
                "B", 2,
                "C", 3
        );
        log.info("Immutable Map: {}", immutableMap);

        try {
            immutableMap.put("D", 4);
        } catch (UnsupportedOperationException e) {
            log.error("Cannot modify immutable map: {}", e.getMessage());
        }
    }

    @Test
    public void testImmutableMapOfEntries() {
        var immutableMap = Map.ofEntries(
                Map.entry("X", 10),
                Map.entry("Y", 20),
                Map.entry("Z", 30)
        );
        log.info("Immutable Map of Entries: {}", immutableMap);

        try {
            immutableMap.remove("X");
        } catch (UnsupportedOperationException e) {
            log.error("Cannot modify immutable map: {}", e.getMessage());
        }
    }

    @Test
    public void testCreateImmutableMapWithLargerSize() {
        var immutableMap = Map.ofEntries(
                Map.entry(1, "One"),
                Map.entry(2, "Two"),
                Map.entry(3, "Three"),
                Map.entry(4, "Four"),
                Map.entry(5, "Five"));
        log.info("Immutable Map of Entries: {}", immutableMap);
    }
}
