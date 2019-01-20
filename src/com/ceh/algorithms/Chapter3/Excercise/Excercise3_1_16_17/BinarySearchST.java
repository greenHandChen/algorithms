package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_16_17;

import com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_2.ArrayST;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public class BinarySearchST<K extends Comparable, V> extends ArrayST<K, V> {
    public BinarySearchST() {
    }

    public BinarySearchST(int cap) {
        super(cap);
    }

    @Override
    public void put(K k, V v) {
        int i = rank(k);
        if (i < size && select(i).equals(k)) {
            values[i] = v;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;
        values[i] = v;
        size++;
    }

    @Override
    public void delete(K k) {
        int i = rank(k);
        if (i >= size || !select(i).equals(k)) return;
        for (int j = i; j < size; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
    }

    @Override
    public V get(K k) {
        int i = rank(k);
        if (select(i).equals(k)) {
            return (V) values[i];
        }
        return null;
    }

    public int rank(K k) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int rst = ((Comparable) k).compareTo(select(mid));
            if (rst < 0) hi = mid - 1;
            else if (rst > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public K ceiling(K k) {
        return select(rank(k));
    }

    public K floor(K k) {
        int i = rank(k);
        if (i < size && select(i).equals(k) && i != 0) return select(i);
        return select(i - 1);
    }

    public K min() {
        return select(0);
    }

    public K max() {
        return select(size - 1);
    }

    public K select(int order) {
        return (K) keys[order];
    }

    @Override
    public boolean contains(K k) {
        return select(rank(k)).equals(k);
    }

    public Iterable<K> keys(int lo, int hi) {
        return null;
    }
}
