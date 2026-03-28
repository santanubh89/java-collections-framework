package com.java.collections;

public class Test {

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.value = 10;
        n1.next = null;

        Node n2 = new Node();
        n2.value = 20;
        n2.next = null;

        n1.next = n2;
    }

}

class Node {

    public int value;

    public Node next;
}