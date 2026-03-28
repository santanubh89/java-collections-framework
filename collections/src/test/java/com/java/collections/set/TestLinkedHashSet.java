package com.java.collections.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class TestLinkedHashSet {

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("X");
        set.add("Y");
        set.add("Z");
        log.info("LinkedHashSet elements in insertion order: {}", set);

        set.addFirst("A");
        set.addLast("O");
        log.info("LinkedHashSet elements after adding elements: {}", set);

        set.removeFirst();
        set.removeLast();
        log.info("LinkedHashSet elements after removing elements: {}", set);

        Set<String> reversedSet = set.reversed();
        log.info("LinkedHashSet elements in reverse order: {}", reversedSet);

        reversedSet.clear();
        log.info("Cleared reversed LinkedHashSet: {}", reversedSet);

        Set<String> immutableSet = Set.of("P", "Q", "R");
        log.info("Immutable Set elements: {}", immutableSet);
        var size = immutableSet.size();
        var isEmpty = immutableSet.isEmpty();
        log.info("Size of LinkedHashSet: {}, isEmpty: {}", size, isEmpty);
    }

}
