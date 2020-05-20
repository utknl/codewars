package com.utknl.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * https://www.codewars.com/kata/52a89c2ea8ddc5547a000863/train/java
 * <p>
 * You are given a node that is the beginning of a linked list. This list always contains a tail
 * and a loop.
 * <p>
 * Your objective is to determine the length of the loop.
 * <p>
 * For example in the following picture the tail's size is 3 and the loop size is 11.
 * <p>
 * // Use the `getNext()` method to get the following node.
 * <p>
 * node.getNext()
 */

public class LoopInspector {

    public int loopSize(Node node) {

        int size = 0;
        List<Node> list = new ArrayList<>();

        while (true) {
            list.add(node);
            size++;
            node = node.getNext();
            for (int i = 0; i < list.size(); i++) {
                if (node.equals(list.get(i))) {
                    return size - i;
                }
            }

        }

    }

}

class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

}
