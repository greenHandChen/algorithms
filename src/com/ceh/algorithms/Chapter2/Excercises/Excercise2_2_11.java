package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2019/1/1.
 */

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * @Author: enHui.Chen
 * @Description: 归并+插入
 * @Data 2019/1/1
 */
public class Excercise2_2_11 {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 66, 22, 222, 67, 1, 18, 100, 99, 88, 42, 49, 56, 45, 76, 65, 0};
        ImproveMerge.sort(array);
        ArrayUtil.printIntArray(array);
    }
}

class ImproveMerge {
    // 子数组长度小于等于SIZE+1时进行插入排序(hi-lo <= SIZE)
    private static final int SIZE = 3;

    public static void sort(int[] array) {
        sort(new int[array.length], array, 0, array.length - 1);
    }

    private static void sort(int[] arrayux, int[] array, int lo, int hi) {
        if (hi <= lo + SIZE) {
            insertSort(array, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arrayux, array, lo, mid);
        sort(arrayux, array, mid + 1, hi);
        if (array[mid] > array[mid + 1])
            Merge.merge(arrayux, array, lo, mid, hi);
    }

    private static void insertSort(int[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
    }
}