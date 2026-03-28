package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class TestHashMap {

    HashMap<Integer, String> hashMap = null;

    @BeforeEach
    public void setup() {
        hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        log.info("Initial HashMap: {}", hashMap);
    }

    @Test
    public void iterateUsingEntry() {
        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        for(Map.Entry<Integer, String> entry : entrySet) {
            log.info("Key: {}, Value: {}", entry.getKey(), entry.getValue());
        }

        hashMap.entrySet().forEach(entry -> {
            log.info("Key: {}, Value: {}", entry.getKey(), entry.getValue());
        });
    }

    @Test
    public void iterateUsingKeySet() {
        Set<Integer> keys = hashMap.keySet();
        for(Integer key : keys) {
            log.info("Key: {}, Value: {}", key, hashMap.get(key));
        }

        hashMap.keySet().forEach(key -> {
            log.info("Key: {}, Value: {}", key, hashMap.get(key));
        });
    }

    @Test
    public void iterateUsingForEach() {
        hashMap.forEach((key, value) -> {
            log.info("Key: {}, Value: {}", key, value);
        });
    }

    @Test
    public void readMapData() {
        log.info("Size of HashMap: {}", hashMap.size());
        Set<Integer> keys = hashMap.keySet();
        Collection<String> values = hashMap.values();
        log.info("Keys: {}", keys);
        log.info("Values: {}", values);
    }

    @Test
    public void accessElements() {
        String val1 = hashMap.get(1);
        log.info("Value for key 1: {}", val1); // One

        String val5 = hashMap.get(5); // Non-existing key
        log.info("Value for key 5: {}", val5); // Null

        String val6 = hashMap.getOrDefault(6, "non-existent");
        log.info("Value for key 6 with default: {}", val6); // non-existent

        boolean containsKey2 = hashMap.containsKey(2);
        log.info("HashMap contains key 2: {}", containsKey2); // true

        boolean containsValueThree = hashMap.containsValue("Three");
        log.info("HashMap contains value 'Three': {}", containsValueThree); // true
    }

    @Test
    public void insertUpdateElements() {
        hashMap.put(5, "Five");
        log.info("HashMap after adding key 5: {}", hashMap);

        hashMap.put(2, "Two Updated");
        log.info("HashMap after updating key 2: {}", hashMap);

        hashMap.putIfAbsent(1, "1 was absent");
        hashMap.putIfAbsent(6, "6 was absent");
        log.info("HashMap after putIfAbsent: {}", hashMap);
    }

    @Test
    public void removeElements() {
        String removedValue = hashMap.remove(3);
        log.info("Removed value for key 3: {}", removedValue);
        log.info("HashMap after removing key 3: {}", hashMap);
    }

    @Test
    public void replace() {
        log.info("Original HashMap: {}", hashMap);
        hashMap.replace(3, "Three", "THREE");
        hashMap.replace(6, "Six");
        log.info("HashMap after replace operations: {}", hashMap);
    }

}
