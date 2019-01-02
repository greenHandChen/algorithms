package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2019/1/3.
 */

import com.ceh.algorithms.utils.PrintUtil;

/**
 * @Author: enHui.Chen
 * @Description: 螺丝和螺帽的问题。
 * @Data 2019/1/3
 */
public class Excercise2_3_15 {
    public static void main(String[] args) {
        // 螺丝
        int[] bolts = {5, 7, 6, 1, 3, 2, 9, 8, 4};
        // 螺帽       3  4  2  1  5  7  8  6  9
        int[] nuts = {1, 9, 5, 4, 8, 2, 7, 3, 6};
        //3 4 2 1 5 7 8 6 9
        match(bolts, nuts);
        PrintUtil.printIntArray(bolts);
        PrintUtil.printIntArray(nuts);
    }

    private static void match(int[] bolts, int[] nuts) {
        match(bolts, nuts, 0, nuts.length - 1);
    }

    private static void match(int[] bolts, int[] nuts, int lo, int hi) {
        if (hi <= lo) return;
        int bolt = bolts[lo];
        int n = preSort(bolt, nuts, lo, hi);
        preSort(nuts[n], bolts, lo, hi);
        match(bolts, nuts, lo, n - 1);// 匹配左侧
        match(bolts, nuts, n + 1, hi);// 匹配右侧
    }

    private static int preSort(int val, int[] array, int lo, int hi) {
        int lt = lo - 1, i = lo, gt = hi + 1;
        if(lt < 0){
            lt =lo;
        }
        int[] a = new int[array.length + 1];
        a[lo] = val;
        for (int k = lo; k <= hi; k++) {
            a[k + 1] = array[k];
        }
        while (i <= gt) {
            if (a[i] < val) exchange(a, lt++, i++);
            else if (a[i] > val) exchange(a, gt--, i);
            else i++;
        }
        for (int k = 1; k < a.length; k++) {
            if (a[k - 1] == a[k]) a[k] = -1;
        }
        int[] c = new int[a.length - 1];
        for (int k = 0, p = 0; p < a.length; k++, p++) {
            if (a[p] == -1) {
                k--;
                continue;
            }
            c[k] = a[p];
        }

        for (int k = lo; k <= hi; k++) {
            array[k] = c[k - lo];
        }
        return lt;
    }

    private static void exchange(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
