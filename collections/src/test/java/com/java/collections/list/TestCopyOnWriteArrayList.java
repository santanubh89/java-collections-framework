package com.java.collections.list;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

    @Test
    public void testCopyOnWriteArrayList() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    }

    @Test
    public void testConcurrentModification() {
        List<Integer> list = null;
        list = new CopyOnWriteArrayList<Integer>();
        // list = new ArrayList<>(); // Concurrent Modification Exception
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer n : list) {
            System.out.println("Number: " + n);
            if (n == 2) {
                list.add(4); // This won't cause ConcurrentModificationException for CopyOnWriteArrayList
            }
        }

        System.out.println("Final List: " + list);
    }

}
