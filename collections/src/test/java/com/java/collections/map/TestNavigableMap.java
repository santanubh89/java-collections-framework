package com.java.collections.map;

import com.java.collections.model.Student;
import com.java.collections.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

@Slf4j
public class TestNavigableMap {

    private NavigableMap<Integer, String> navigableMap = null;

    @BeforeEach
    public void createNavigableMap() {
        navigableMap = new TreeMap<>();
        navigableMap.put(5, "Five");
        navigableMap.put(1, "One");
        navigableMap.put(3, "Three");
        navigableMap.put(9, "Nine");
        navigableMap.put(7, "Seven");
        navigableMap.put(0, "Zero");
        navigableMap.put(4, "Four");
        navigableMap.put(8, "Eight");
        navigableMap.put(2, "Two");
        navigableMap.put(6, "Six");
    }

    @Test
    public void testNavigableMapOperations() {
        // Descending Map
        NavigableMap<Integer, String> descendingMap = navigableMap.descendingMap();
        log.info("Descending NavigableMap: {}", descendingMap);
    }

    @Test
    public void testFirstAndLastEntry() {
        // Poll First and Last Entries
        log.info("Poll First Entry: {}", navigableMap.pollFirstEntry());
        log.info("NavigableMap after polling first entry: {}", navigableMap);
        log.info("Poll Last Entry: {}", navigableMap.pollLastEntry());
        log.info("NavigableMap after polling last entry: {}", navigableMap);
    }

    @Test
    public void testHigherAndLowerEntry() {
        // Higher Entry
        log.info("Higher Entry for key 5: {}", navigableMap.higherEntry(5));
        log.info("Higher Entry for key 8: {}", navigableMap.higherEntry(8));
        log.info("Higher Entry for key 9: {}", navigableMap.higherEntry(9));
        log.info("Higher Entry for key -7: {}", navigableMap.higherEntry(-7));

        // Lower Entry
        log.info("Lower Entry for key 5: {}", navigableMap.lowerEntry(5));
        log.info("Lower Entry for key 2: {}", navigableMap.lowerEntry(2));
        log.info("Lower Entry for key 0: {}", navigableMap.lowerEntry(0));
        log.info("Lower Entry for key 10: {}", navigableMap.lowerEntry(10));
        log.info("Lower Entry for key -1: {}", navigableMap.lowerEntry(-1));
    }

    @Test
    public void testCeilingAndFloorEntry() {
        // Ceiling Entry
        log.info("Ceiling Entry for key 5: {}", navigableMap.ceilingEntry(5));
        log.info("Ceiling Entry for key 6: {}", navigableMap.ceilingEntry(6));
        log.info("Ceiling Entry for key 11: {}", navigableMap.ceilingEntry(11));
        log.info("Ceiling Entry for key -7: {}", navigableMap.ceilingEntry(-7));

        // Floor Entry
        log.info("Floor Entry for key 5: {}", navigableMap.floorEntry(5));
        log.info("Floor Entry for key 4: {}", navigableMap.floorEntry(4));
        log.info("Floor Entry for key 10: {}", navigableMap.floorEntry(10));
        log.info("Floor Entry for key -1: {}", navigableMap.floorEntry(-1));
    }

    @Test
    public void testCustomClass() {
        List<Student> students = StudentService.students();
        HashMap<Student, Integer> studentMap = new HashMap<>();

        students.parallelStream().forEach(student -> studentMap.put(student, student.getId()));
        log.info("Student HashMap: {}", studentMap);

        NavigableMap<Student, Integer> studentNavigableMap = new TreeMap<>(studentMap);
        log.info("Student NavigableMap: {}", studentNavigableMap);

    }
}
