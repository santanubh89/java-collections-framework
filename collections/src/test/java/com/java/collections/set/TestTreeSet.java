package com.java.collections.set;

import com.java.collections.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

@Slf4j
public class TestTreeSet {

    @Test
    public void testTreeSet() {
        // Demonstrate TreeSet with Strings
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Orange");
        treeSet.add("Apple"); // Duplicate
        log.info("TreeSet: {}", treeSet);

        // Iteration
        for (String fruit : treeSet) {
            log.info("Element: {}", fruit);
        }

        // First and Last
        log.info("First: {}", treeSet.first());
        log.info("Last: {}", treeSet.last());

        // SubSet, HeadSet, TailSet
        log.info("HeadSet (before Mango): {}", treeSet.headSet("Mango"));
        log.info("TailSet (from Mango): {}", treeSet.tailSet("Mango"));
        log.info("SubSet (Apple to Orange): {}", treeSet.subSet("Apple", "Orange"));

        // Remove
        treeSet.remove("Banana");
        log.info("After removing 'Banana': {}", treeSet);

        // Custom objects (Person) with Comparator
        TreeSet<Person> personSet = new TreeSet<>((p1, p2) -> {
            int cmp = Integer.compare(p1.getId(), p2.getId());
            if (cmp == 0) {
                return p1.getName().compareTo(p2.getName());
            }
            return cmp;
        });
        personSet.add(new Person(30, "John"));
        personSet.add(new Person(25, "Jane"));
        personSet.add(new Person(30, "John")); // Duplicate
        personSet.add(new Person(28, "Alice"));
        log.info("Person TreeSet: {}", personSet);
    }
}
