package com.java.collections.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TestArrayList {
    ArrayList<Integer> numbers = null;

    @BeforeEach
    public void setUp() {
        numbers = new ArrayList<Integer>(List.of(5, 1, 9, 7, 3));
    }

    @Test
    public void testCreateList() {
        // New ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(9);
        numbers.add(7);
        numbers.add(3);
        log.info("List: {}", numbers);

        // Copying an existing list
        ArrayList<Integer> numbersCopy = new ArrayList<>(numbers);
        log.info("List Copy: {}", numbersCopy);

        // Immutable ArrayList
        List<Integer> immutableList = List.of(2, 4, 6, 8, 10);
        log.info("Immutable List({}): {}", immutableList.getClass(), immutableList);

        // Create List from Arrays
        Integer[] numArray = {5, 1, 9, 7, 3};
        ArrayList<Integer> arrayListFromArray = new ArrayList<>(List.of(numArray));
        log.info("ArrayList from Array: {}", arrayListFromArray);
    }

    @Test
    public void testTraverseList() {
        log.info("Size of the list: {}", numbers.size());

        for (int index = 0; index < numbers.size(); index++) {
            log.info("Element at index {} : {}", index, numbers.get(index));
        }

        int index = 0;
        for(int num : numbers) {
            log.info("Element at index {} : {}", index, num);
            index++;
        }

        log.info("Element at index 2 : {}", numbers.get(2));
    }

    @Test
    public void testIfElementExists() {
        log.info("List contains 7: {}", numbers.contains(7));
        log.info("List contains 4: {}", numbers.contains(4));
    }

    @Test
    public void testAddElement() {
        log.info("Original List: {}", numbers);
        numbers.add(4); // Appends at the end
        log.info("List after adding 4: {}", numbers);

        numbers.add(2, 8); // Inserts at index 2
        log.info("List after adding 8 at index 2: {}", numbers);

        List<Integer> newNumbers = new ArrayList<>();
        newNumbers.addAll(numbers);
        log.info("List after using addAll: {}", newNumbers);
    }

    @Test
    public void testRemoveElement() {
        log.info("Original List: {}", numbers);
        numbers.remove(Integer.valueOf(3));
        log.info("List after removing 3: {}", numbers);
        numbers.remove(2);
        log.info("List after removing element at index 2: {}", numbers);
    }

    @Test
    public void testModifyElement() {
        log.info("Original List: {}", numbers);
        numbers.set(2, 8);
        log.info("List after updating 8 at index 2: {}", numbers);
    }

    @Test
    public void testResizing() throws NoSuchFieldException, IllegalAccessException {
        //Add to Java Options: --add-opens java.base/java.util=ALL-UNNAMED
        ArrayList<Integer> numbers = new ArrayList<>(6);
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(numbers);

        log.info("Initial capacity before adding any elements: {}", elementData.length); // 6

        for (int i=0; i<6; i++) {
            numbers.add(i);
        }
        elementData = (Object[]) field.get(numbers);
        log.info("Initial capacity after adding 6 elements: {}", elementData.length); // 6

        numbers.add(0);
        elementData = (Object[]) field.get(numbers);
        log.info("Initial capacity after adding 1 more element: {}", elementData.length); // 9

        for (int i=0; i<3; i++) {
            numbers.add(i);
        }
        elementData = (Object[]) field.get(numbers);
        log.info("Initial capacity after adding 3 more elements: {}", elementData.length); //13

        for (int i=0; i<5; i++) {
            numbers.remove(i);
        }

        elementData = (Object[]) field.get(numbers);
        log.info("Initial capacity after removing 7 elements: {}", elementData.length); //13

        numbers.trimToSize();
        elementData = (Object[]) field.get(numbers);
        log.info("Initial capacity after calling trimToSize: {}", elementData.length); //5
    }

    @Test
    public void testArray() {
        String[] array = new String[] {"Apple", "Orange", "Banana"};
        List<String> arrayList = Arrays.asList(array);
        log.info("ArrayList: {}", arrayList);

        array = arrayList.toArray(new String[0]);
        log.info("Array: {}", Arrays.toString(array));
    }

    @Test
    public void testSort() {
        Collections.sort(numbers);
        log.info("Sorted List: {}", numbers);

        // Natural sorting
        numbers = new ArrayList<>(List.of(5, 1, 9, 7, 3));
        numbers.sort(null);
        log.info("Sorted List: {}", numbers);
    }

}
