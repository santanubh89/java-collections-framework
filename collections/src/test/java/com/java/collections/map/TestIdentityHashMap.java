package com.java.collections.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.IdentityHashMap;

@Slf4j
public class TestIdentityHashMap {

    @Test
    public void testIdentityHashCode() {
        String str1 = new String("example");
        String str2 = new String("example");

        int identityHashCode1 = System.identityHashCode(str1);
        int identityHashCode2 = System.identityHashCode(str2);

        log.info("Identity HashCode of str1: {}", identityHashCode1);
        log.info("Identity HashCode of str2: {}", identityHashCode2);

        int hashCode1 = str1.hashCode();
        log.info("HashCode of str1 (content-based): {}", hashCode1);
        String hashCode2 = String.valueOf(str2.hashCode());
        log.info("HashCode of str2 (content-based): {}", hashCode2);
    }

    @Test
    public void testIdentityHashMap() {
        // IdentityHashMap uses reference equality (==) instead of object equality (equals())
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();

        String key1 = new String("key");
        String key2 = new String("key"); // Different object with same content

        identityMap.put(key1, "value1");
        identityMap.put(key2, "value2");

        log.info("IdentityHashMap Size: {}", identityMap.size()); // Should be 2
        log.info("Value for key1: {}", identityMap.get(key1)); // Should be value1
        log.info("Value for key2: {}", identityMap.get(key2)); // Should be value2
        log.info("Value for key: {}", identityMap.get(new String("key"))); // null
        log.info("Value for key: {}", identityMap.get("key")); // null
    }

}
