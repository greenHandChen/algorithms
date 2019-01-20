package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_2;

import com.ceh.algorithms.Chapter1.Queue.Queue;
import com.ceh.algorithms.Chapter3.Excercise.base.ST;

/**
 * @Author: enHui.Chen
 * @Description: 无序符号表API的实现.
 */
public class ArrayST<K, V> implements ST<K, V> {
    protected Object[] keys;
    protected Object[] values;
    protected int size = 0;
    protected static final int DEFAULT_SIZE = 16;

    public ArrayST() {
        this(DEFAULT_SIZE);
    }

    public ArrayST(int cap) {
        this.keys = new Object[cap];
        this.values = new Object[cap];
    }

    @Override
    public void put(K k, V v) {
        delete(k);
        if (size == keys.length) resize(keys.length << 1);
        keys[size] = k;
        values[size++] = v;
    }

    @Override
    public void delete(K k) {
        for (int i = 0; i < size; i++) {
            if (k.equals((K) keys[i])) {
                exchange(i, --size);
                keys[size] = null;
                values[size] = null;
                return;
            }
        }
    }

    @Override
    public V get(K k) {
        for (int i = 0; i < size; i++) {
            if (k.equals((K) keys[i])) return (V) values[i];
        }
        return null;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> queue = new Queue<>();
        for (int i = 0; i < size; i++) {
            queue.enqueue((K) keys[i]);
        }
        return queue;
    }

    @Override
    public boolean contains(K k) {
        for (int i = 0; i < size; i++) {
            if (k.equals((K) keys[i])) return true;
        }
        return false;
    }

    public void resize(int newCap) {
        Object[] newKeys = new Object[newCap];
        Object[] newValues = new Object[newCap];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void exchange(int index1, int index2) {
        Object o1 = keys[index1];
        keys[index1] = keys[index2];
        keys[index2] = o1;
        Object o2 = values[index1];
        values[index1] = values[index2];
        values[index2] = o2;
    }

    @Override
    public String toString() {
        System.out.println("{");
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) continue;
            System.out.println("    \"" + keys[i] + "\":\"" + values[i] + "\"");
        }
        System.out.println("}");
        return null;
    }
}
