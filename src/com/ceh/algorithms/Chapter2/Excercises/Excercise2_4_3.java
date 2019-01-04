package com.ceh.algorithms.Chapter2.Excercises;

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * @Author: enHui.Chen
 * @Description: 有序/无序数组以及堆实现优先队列的插入元素, 以及删除最大元素.
 */
public class Excercise2_4_3 {
    public static void main(String[] args) {
//        sortedArrayTest();
//        unsortedArrayTest();
        maxPOTest();
    }

    public static void maxPOTest() {
        MaxPQ maxPQ = new MaxPQ();
        maxPQ.insert(5);
        maxPQ.insert(23);
        maxPQ.insert(33);
        maxPQ.insert(99);
        maxPQ.insert(88);
        maxPQ.insert(15);
        maxPQ.insert(150);
        maxPQ.insert(42);
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
    }

    public static void sortedArrayTest() {
        SortedArray sortedArray = new SortedArray();
        sortedArray.insert(5);
        sortedArray.insert(23);
        sortedArray.insert(33);
        sortedArray.insert(1);
        sortedArray.insert(88);
        sortedArray.insert(15);
        sortedArray.insert(150);
        sortedArray.insert(42);
        System.out.println(sortedArray.delMax());
        System.out.println(sortedArray.delMax());
        System.out.println(sortedArray.delMax());
        System.out.println(sortedArray.delMax());
        System.out.println(sortedArray.delMax());
    }

    public static void unsortedArrayTest() {
        UnsortedArray unsortedArray = new UnsortedArray();
        unsortedArray.insert(115);
        unsortedArray.insert(23);
        unsortedArray.insert(33);
        unsortedArray.insert(15);
        unsortedArray.insert(78);
        unsortedArray.insert(15);
        unsortedArray.insert(150);
        unsortedArray.insert(42);
        System.out.println(unsortedArray.delMax());
        System.out.println(unsortedArray.delMax());
        System.out.println(unsortedArray.delMax());
        System.out.println(unsortedArray.delMax());
        System.out.println(unsortedArray.delMax());
    }
}

class MaxPQ {
    private int[] array;
    private int N = 0;

    public MaxPQ() {
        array = new int[1 + 16];
    }

    public void insert(int e) {
        array[++N] = e;
        swim(N);
    }

    public int delMax() {
        int max = array[1];
        ArrayUtil.exchange(array, 1, N--);
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && array[k >> 1] < array[k]) {
            ArrayUtil.exchange(array, k >> 1, k);
            k = k >> 1;
        }
    }

    private void sink(int k) {
        while (k << 1 <= N) {
            int j = k << 1;
            if (j < N && array[j] < array[j + 1]) j++;
            if (array[j] < array[k]) break;
            ArrayUtil.exchange(array, j, k);
            k = j;
        }
    }
}

class SortedArray {
    // e的size
    private int N = 0;
    private int[] array;

    public SortedArray() {
        array = new int[16];
    }

    public void insert(int e) {
        array[N++] = e;
        insertionSort(array);
    }

    public int delMax() {
        if (N == 0) return -1;
        return array[--N];
    }

    private void insertionSort(int[] array) {
        for (int j = N - 1; j > 0 && array[j] < array[j - 1]; j--)
            ArrayUtil.exchange(array, j, j - 1);
    }

    public void show() {
        ArrayUtil.printIntArray(array);
    }
}

class UnsortedArray {
    // e的size
    private int N = 0;
    private int[] array;

    public UnsortedArray() {
        array = new int[16];
    }

    public void insert(int e) {
        array[N++] = e;
    }

    public int delMax() {
        if (N == 0) return -1;
        sort(array);
        return array[--N];
    }

    private void sort(int[] array) {
        for (int j = N - 2; j >= 0; j--) {
            if (array[N - 1] < array[j]) ArrayUtil.exchange(array, N - 1, j);
        }

    }

    public void show() {
        ArrayUtil.printIntArray(array);
    }
}

