package com.java.collections.iterable;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class TestIterable {

    @Test
    public void demoIterable() {
        Iterable<Integer> iterable = () -> new Iterator<>() {
            private int current = 1;
            private final int max = 5;

            @Override
            public boolean hasNext() {
                return current <= max;
            }

            @Override
            public Integer next() {
                return current++;
            }
        };

        for (Integer number : iterable) {
            log.info("Element: {}", number);
        }
    }

    @Test
    public void testIterator() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            log.info("Element: {}", iterator.next());
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        log.info("List after removing even numbers: {}", list);

    }

}
