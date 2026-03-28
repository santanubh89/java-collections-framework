package com.java.collections.set;

import com.java.collections.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class TestHashSet {

    private HashSet<String> set = null;

    @BeforeEach
    public void createSet() {
        set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        log.info("Initial Set: {}", set);
    }

    @Test
    public void testReadAllElements() {
        for(String element : set) {
            log.info("Element: {}", element);
        }

        set.forEach(el -> log.info("Element using forEach: {}", el));

        set.iterator().forEachRemaining(el -> log.info("Element using Iterator: {}", el));

        log.info("Size = {}", set.size());

        log.info("Size = {}", set.spliterator().estimateSize());

    }

    @Test
    public void testDuplicateElements() {
        boolean added = set.add("A"); // Duplicate
        log.info("Trying to add duplicate element 'A': {}", added); // Should be false

        added = set.add("E"); // New element
        log.info("Trying to add new element 'E': {}", added); // Should be true

        log.info("Current Set: {}", set);
    }

    @Test
    public void testRemoveElements() {
        boolean removed = set.remove("B");
        log.info("Removing element 'B': {}", removed); // Should be true

        removed = set.remove("Z");
        log.info("Trying to remove non-existing element 'Z': {}", removed); // Should be false

        log.info("Current Set after removals: {}", set);

        set.removeAll(Set.of("A", "C"));
        log.info("Set after removing 'B' and 'C': {}", set);

    }

    @Test
    public void testContainsElement() {
        boolean contains = set.contains("C");
        log.info("Set contains 'C': {}", contains); // Should be true

        contains = set.contains("Y");
        log.info("Set contains 'Y': {}", contains); // Should be false
    }

    @Test
    public void testCustomObjects() {
        Set<Person> personSet = new HashSet<>();
        Person p1 = new Person(30, "John");
        Person p2 = new Person(25, "Jane");
        Person p3 = new Person(30, "John"); // Duplicate based on attributes

        personSet.add(p1);
        personSet.add(p2);
        boolean added = personSet.add(p3); // Should be false if equals and hashCode are overridden

        log.info("Person Set: {}", personSet);
        log.info("Trying to add duplicate Person p3: {}", added); // Should be false
    }

}
