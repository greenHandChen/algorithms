package com.ceh.algorithms.Chapter2.Excercises;

import com.ceh.algorithms.utils.PrintUtil;

/**
 * Created by enHui.Chen on 2019/1/2.
 */
public class Excercise2_3_5 {
    public static void main(String[] args) {
        int[] array = {4, 5, 5, 4, 5, 3, 3, 3, 4, 5, 4, 5, 4, 4, 4, 4, 5, 5, 5, 5};
        QuickThreeWaySort.sort(array);
        PrintUtil.printIntArray(array);
    }
}

class QuickThreeWaySort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi, v = array[lo];
        while (i <= gt) {
            int a = array[i];
            if (a < v) exchange(array, lt++, i++);
            else if (a > v) exchange(array, gt--, i);
            else i++;
        }
        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);
    }

    private static void exchange(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
