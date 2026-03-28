package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
public class TestLRUCache {

    @Test
    public void testLRUCache() {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.get(1); // Access key 1 to make it recently used
        cache.put(4, "Four"); // This should evict key 2


        log.info("Cache after adding 4 elements (capacity 3): {}", cache);
    }

    class LRUCache<K, V> extends java.util.LinkedHashMap<K, V> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

}