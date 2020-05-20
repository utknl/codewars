package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoopInspectorTest {

    @Test
    public void loop_size_of_5() {

        // 1 2 3 4 5 6 7 8 4

        // 1    1
        // 2    2
        // 3    3
        // 4    4
        // 5    5
        // 6    6
        // 7    7
        // 8    8
        // 4    9

        Node node4 = new Node(4, null);
        Node node1 = new Node(1, new Node(2, new Node(3, node4)));
        node4.next = new Node(5, new Node(6, new Node(7, new Node(8, node4))));

        int result = new LoopInspector().loopSize(node1);
        assertEquals("Incorrect loop size", 5, result);
    }


}