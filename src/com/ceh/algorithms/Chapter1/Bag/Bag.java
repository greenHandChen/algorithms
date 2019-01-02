package com.ceh.algorithms.Chapter1.Bag;

import java.util.Iterator;

/**
 * Created by enHui.Chen on 2018/12/30.
 */
public class Bag<T> implements Iterable<T> {
    private Node first;

    public void add(T newVal) {
        Node oldFirst = first;
        first = new Node();
        first.val = newVal;
        first.next = oldFirst;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T val = currentNode.val;
            currentNode = currentNode.next;
            return val;
        }
    }

    private class Node {
        private Node next;
        private T val;
    }
}
