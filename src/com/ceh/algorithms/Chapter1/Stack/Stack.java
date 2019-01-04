package com.ceh.algorithms.Chapter1.Stack;

public class Stack<T> {
    private Node first;
    private int modCount;

    public void push(T newVal) {
        Node oldFirst = first;
        first = new Node();
        first.val = newVal;
        first.next = oldFirst;
        modCount++;
    }

    public T pop() {
        T val = first.val;
        first = first.next;
        modCount--;
        return val;
    }

    private class Node {
        private Node next;
        private T val;
    }
}
