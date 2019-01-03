package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2018/12/31.
 */

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * @Author: enHui.Chen
 * @Description: 修改归并排序时:将静态成员变量的辅助数组改为由参数传递的辅助数组
 * @Data 2018/12/31
 */
public class Excercise2_2_9 {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 66, 22, 222, 67, 1, 18, 100, 99, 88, 42, 49, 56, 45, 76, 65, 0};
        Merge.sort(array);
        ArrayUtil.printIntArray(array);
    }
}

class Merge {

    static void merge(int[] arrayux, int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            arrayux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = arrayux[j++];
            else if (j > hi) array[k] = arrayux[i++];
            else if (arrayux[j] < arrayux[i]) array[k] = arrayux[j++];
            else array[k] = arrayux[i++];
        }
    }

    public static void sort(int[] array) {
        sort(new int[array.length], array, 0, array.length - 1);
    }

    private static void sort(int[] arrayux, int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(arrayux, array, lo, mid);
        sort(arrayux, array, mid + 1, hi);
        merge(arrayux, array, lo, mid, hi);
    }
}
