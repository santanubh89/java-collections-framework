package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class TestLinkedHashMap {

    @Test
    public void testInsertionOrder() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(11, 0.8f);
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        map.keySet().forEach(key -> {
            log.info("Key: {}, Value: {}", key, map.get(key));
        });
    }

    @Test
    public void testAccessOrder() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(11, 0.8f, true);
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        map.get(1); // --> Moves key 1 to the end => {2=Two, 3=Three, 4=Four, 1=One}
        map.get(3); // --> Moves key 3 to the end => {2=Two, 4=Four, 1=One, 3=Three}

        map.entrySet().forEach(entry -> {
            log.info("Key: {}, Value: {}", entry.getKey(), entry.getValue()); // 2 4 1 3
        });
    }

}
