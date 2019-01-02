package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2019/1/1.
 */

/**
 * @Author: enHui.Chen
 * @Description: 快速归并,去除了内循环的条件
 * @Data 2019/1/1
 */
public class Excercise2_2_10 {
    private static void merge(int[] arrayux, int[] array, int lo, int mid, int hi) {
        int i = lo, j = hi;
        for (int k = lo; k <= mid; k++) {
            arrayux[k] = array[k];
        }
        for (int k = mid + 1; k <= hi; k++) {
            arrayux[k] = arrayux[hi - k + mid + 1];
        }
        for (int k = lo; k <= hi; k++) {
            if (arrayux[j] < arrayux[i]) array[k] = arrayux[j--];
            else array[k] = array[i++];
        }
    }
}
