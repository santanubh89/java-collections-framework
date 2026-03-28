package com.java.collections.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

@Slf4j
public class TestStack {

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        // Adds elements to the stack
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        log.info("Stack after pushing 5 elements: {}", stack);

        // Removes the top element
        Integer popped = stack.pop();
        log.info("Popped element: {}, Current stack: {}", popped, stack);

        // Add elements at first and last
        stack.addFirst(-1);
        stack.addLast(9);
        log.info("Stack after adding -1 at first and 9 at last: {}", stack);

        // Access the element at top
        Integer peek = stack.peek();
        log.info("Peek element: {}, Current stack: {}", peek, stack);

        // Search
        int position = stack.search(2);
        log.info("Position of element 2 from top: {}", position);

        // Remove elements from first and last
        Integer first = stack.removeFirst();
        Integer last = stack.removeLast();
        log.info("Removed first element: {}, Removed last element: {}, Current stack: {}", first, last, stack);

        // Remove element at specific index and by value
        stack.removeElementAt(2);
        stack.removeElement(Integer.valueOf(0));
        log.info("Stack after removing element at index 2 and element 0: {}", stack);
    }

    @Test
    public void testLinkedListAsStack() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // Push equivalent
        linkedList.addLast(0);
        linkedList.addLast(1);
        linkedList.addLast(2);
        log.info("LinkedList as Stack after pushing 3 elements: {}", linkedList);

        // Pop equivalent
        Integer popped = linkedList.removeLast();
        log.info("Popped element from LinkedList Stack: {}, Current LinkedList: {}", popped, linkedList);

        // Peek
        Integer peek = linkedList.peekLast();
        log.info("Peek element from LinkedList Stack: {}, Current LinkedList: {}", peek, linkedList);
    }

    @Test
    public void testArrayListAsStack() {
        // ArrayList does not have stack-specific methods, but we can simulate stack behavior
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Push equivalent
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        log.info("ArrayList as Stack after pushing 3 elements: {}", arrayList);

        // Pop equivalent
        Integer popped = arrayList.removeLast();
        log.info("Popped element from ArrayList Stack: {}, Current ArrayList: {}", popped, arrayList);

        // Peek
        Integer peek = arrayList.getLast();
        log.info("Peek element from ArrayList Stack: {}, Current ArrayList: {}", peek, arrayList);
    }

}
