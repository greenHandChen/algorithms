package com.ceh.algorithms.Chapter2.Excercises;

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * Created by enHui.Chen on 2019/1/3.
 */
 /**
   * @Author: enHui.Chen
   * @Description: 快速三向切分。1.左右两端与给定值相等 2.找完相等将左右两侧汇聚中中部 3.重复1,2
   * @Data 2019/1/4
   */
public class Excercise2_3_22 {
    public static void main(String[] args) {
        int[] array = {66, 6, 7, 66, 22, 222, 66, 67, 1, 18, 100, 11,66,99, 66, 88, 66, 42, 49, 56, 66,66,66,66, 45, 66,66,66,66,76,66,66,66,66, 65, 0};
        QuickThreeWaySort2.sort(array);
        ArrayUtil.printIntArray(array);
    }
}

class QuickThreeWaySort2 {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }


    private static void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int p = lo, i = lo - 1;
        int q = hi, j = hi + 1;
        int v = array[lo];
        while (true) {
            while (array[++i] < v) if (i == hi) break;
            while (array[--j] > v) if (j == lo) break;

            if (i >= j) break;
            ArrayUtil.exchange(array, i, j);
            if (array[i] == v) ArrayUtil.exchange(array, p++, i);
            if (array[j] == v) ArrayUtil.exchange(array, q--, j);
        }
        // 防止无法切分(保证i一定处于右侧的临界点)
        i = j + 1;
        for (int k = lo; k < p; k++) {// 左侧p-lo个
            ArrayUtil.exchange(array, k, j--);
        }
        for (int k = q + 1; k <= hi; k++) {// 右侧hi-q个
            ArrayUtil.exchange(array, k, i++);
        }
        sort(array, lo, j);
        sort(array, i, hi);
    }

}
