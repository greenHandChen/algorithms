package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2019/1/1.
 */

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * @Author: enHui.Chen
 * @Description: 间接排序(元素索引排序), 返回的数组是按从小到大排序的原数组中元素的索引位
 */
public class Excercise2_2_20 {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 66, 22, 222, 67, 1, 18, 100, 99, 88, 42, 49, 56, 45, 76, 65, 0};
        int[] index = IndirectMerge.sort(array);
        ArrayUtil.printIntArray(index);
    }
}

class IndirectMerge {
    // 子数组长度小于等于SIZE+1时进行插入排序(hi-lo <= SIZE)
    private static final int SIZE = 3;

    public static int[] sort(int[] array) {
        int[] index = new int[array.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        sort(index, new int[array.length], array, 0, array.length - 1);
        return index;
    }

    private static void sort(int[] index, int[] arrayux, int[] array, int lo, int hi) {
        if (hi <= lo + SIZE) {
            insertSort(index, array, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(index, arrayux, array, lo, mid);
        sort(index, arrayux, array, mid + 1, hi);
        if (array[index[mid]] > array[index[mid + 1]])
            merge(index, arrayux, array, lo, mid, hi);
    }

    static void merge(int[] index, int[] arrayux, int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            arrayux[k] = index[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) index[k] = arrayux[j++];
            else if (j > hi) index[k] = arrayux[i++];
                // arrayux[j] 原数组中的元素索引
            else if (array[arrayux[j]] < array[arrayux[i]]) index[k] = arrayux[j++];
            else index[k] = arrayux[i++];
        }
    }

    private static void insertSort(int[] index, int[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && array[index[j]] < array[index[j - 1]]; j--) {
                int tmp = index[j];
                index[j] = index[j - 1];
                index[j - 1] = tmp;
            }
        }
    }
}