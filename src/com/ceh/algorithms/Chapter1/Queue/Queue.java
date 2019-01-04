package com.ceh.algorithms.Chapter1.Queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int modCount;

    public void enqueue(T newVal) {
        Node oldLast = last;
        last = new Node();
        last.val = newVal;
        if (first == null) first = last;
        else oldLast.next = last;
        modCount++;
    }

    public T dequeue() {
        T val = first.val;
        first = first.next;
        if (first == null) last = null;
        modCount--;
        return val;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T val = current.val;
            current = current.next;
            return val;
        }
    }

    private class Node {
        private Node next;
        private T val;
    }
}
