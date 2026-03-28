package com.java.collections.map;

import com.java.collections.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestObjectEquality {

    @Test
    public void testObjectEquality() {
        Map<Person, Integer> personMap = new HashMap<>();
        personMap.put(new Person(1, "Alice"), 30);
        personMap.put(new Person(2, "Bob"), 25);
        personMap.put(new Person(3, "Charlie"), 35);
        personMap.put(new Person(1, "Alice"), 28); // Duplicate key based on id

        log.info("Person Map: {}", personMap);

        Person searchPerson = new Person(2, "Bob");
        Integer age = personMap.get(searchPerson);
        System.out.println("Age of " + searchPerson.getName() + ": " + age);

    }

}
