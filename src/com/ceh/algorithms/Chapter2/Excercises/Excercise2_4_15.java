package com.ceh.algorithms.Chapter2.Excercises;

/**
 * @Author: enHui.Chen
 * @Description: 构造面向最小元素的堆, 并在线性时间内检测是否是最小元素堆
 */
public class Excercise2_4_15 {
    public static void main(String[] args) {
        MinPQ<Integer> minPQ = new MinPQ();
        minPQ.insert(5);
        minPQ.insert(23);
        minPQ.insert(33);
        minPQ.insert(5);
        minPQ.insert(88);
        minPQ.insert(15);
        minPQ.insert(150);
        minPQ.insert(42);
        minPQ.insert(11);
        System.out.println(minPQ.isMinPQ());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
    }

}

class MinPQ<T> {
    private Object[] array;
    private int N = 0;

    public MinPQ() {
        this(16);
    }

    public MinPQ(int size) {
        array = new Object[1 + size];
    }

    public void insert(T e) {
        if (N == array.length - 1) resize(N << 1);
        array[++N] = e;
        minSwim(N);
    }

    public T delMin() {
        T min = (T) array[1];
        exchange(1, N);
        array[N--] = null;
        minSink(1);
        return min;
    }

    private void minSwim(int k) {
        while (k > 1 && compare(array[k >> 1], array[k]) == 1) {
            exchange(k >> 1, k);
            k = k >> 1;
        }
    }

    private void minSink(int k) {
        while (k << 1 <= N) {
            int j = k << 1;
            if (j < N && compare(array[j], array[j + 1]) == 1) j++;
            if (compare(array[k], array[j]) == -1) break;
            exchange(k, j);
            k = j;
        }
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[1 + newSize];
        for (int i = 1; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isMinPQ() {
        return isMinPQ(1);
    }

    private boolean isMinPQ(int k) {
        if (k << 1 > N) return true;
        int i = k << 1;
        if (compare(array[k], array[i]) == 1) return false;
        if (i < N && compare(array[k], array[i + 1]) == 1) return false;
        isMinPQ(i);// 检测左侧
        isMinPQ(i + 1);// 检测右侧
        return true;
    }

    private void exchange(int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getSize() {
        return N;
    }

    private int compare(Object x, Object y) {
        if (((Comparable) x).compareTo(y) == 1) return 1;
        if (((Comparable) x).compareTo(y) == -1) return -1;
        return 0;
    }
}
