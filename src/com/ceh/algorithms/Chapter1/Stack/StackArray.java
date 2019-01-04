package com.ceh.algorithms.Chapter1.Stack;

import java.util.Iterator;

public class StackArray<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public StackArray() {
        array = new Object[DEFAULT_SIZE];
    }

    public StackArray(int size) {
        array = new Object[size];
    }

    public void push(T newVal) {
        array[size++] = newVal;
        if (size == array.length) resize(size << 1);
    }

    public T pop() {
        T t = (T) array[--size];
        array[size] = null;
        return t;
    }

    public void resize(int newLength) {
        Object[] tmpArray = new Object[newLength];
        for (int i = 0; i < size; i++) {
            tmpArray[i] = array[i];
        }
        array = tmpArray;
    }

    public int length() {
        return array.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackArrayIterator();
    }

    private class StackArrayIterator implements Iterator<T> {
        private Object[] tmpArray = array;
        private int tmpSize = size;

        @Override
        public boolean hasNext() {
            return tmpSize != 0;
        }

        @Override
        public T next() {
            return (T) tmpArray[--tmpSize];
        }

        @Override
        public void remove() {

        }
    }
}
