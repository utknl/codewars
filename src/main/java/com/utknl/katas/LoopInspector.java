package com.utknl.katas;

public class LoopInspector {

    public int loopSize(Node node) {

        int size = 0;

        Node x = node.getNext();

        while (!x.equals(node)) {
            x = node.getNext();
            size++;
        }

        return size;


    }

}

class Node<T> {
    T value;
    Node<T> next;
    
    Node getNext(){
        return next;
    }
}
