package com.ceh.algorithms.Chapter3.Excercise.Excercise2_5_24;


/**
 * @Author: enHui.Chen
 * @Description: 稳定优先队列
 */
public class StablePQ<T extends Comparable> {
    private Object[] obj;
    private int N = 0;

    /**
     * 记录插入时的顺序 start
     */
    private int[] orderArray;
    private int order = 0;

    /**
     * 记录插入时的顺序 end
     */

    public StablePQ() {
        this(15);
    }

    public StablePQ(int cap) {
        this.obj = new Object[cap + 1];
        this.orderArray = new int[cap + 1];
    }

    public void insert(Object o) {
        obj[++N] = o;
        orderArray[N] = ++order;
        minSwim(N);
    }

    public T delMin() {
        Object o = obj[1];
        exchange(1, N);
        obj[N] = null;
        orderArray[N--] = 0;
        minSink(1);
        return (T) o;
    }

    private void minSwim(int k) {
        while (k > 1 && compare(k >> 1, k)) {
            exchange(k >> 1, k);
            k = k >> 1;
        }
    }

    private void minSink(int k) {
        while (k << 1 <= N) {
            int x = k << 1;
            if (x < N && compare(x, x + 1)) x++;
            if (compare(x, k)) return;
            exchange(k, x);
            k = x;
        }
    }

    private boolean compare(int o1, int o2) {
        if (((Comparable) obj[o1]).compareTo(obj[o2]) > 0) return true;
        if (((Comparable) obj[o1]).compareTo(obj[o2]) < 0) return false;
        // 保证了重复元素的稳定,找更小的插入order
        return orderArray[o1] > orderArray[o2];
    }

    private void exchange(int o1, int o2) {
        Object tmpObj = obj[o1];
        obj[o1] = obj[o2];
        obj[o2] = tmpObj;
        int tmpOrder = orderArray[o1];
        orderArray[o1] = orderArray[o2];
        orderArray[o2] = tmpOrder;
    }

    public int getN() {
        return N;
    }
}