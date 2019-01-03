package com.ceh.algorithms.Chapter2.Excercises;

/**
 * Created by enHui.Chen on 2019/1/3.
 */

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * @Author: enHui.Chen
 * @Description: 螺丝和螺帽的问题。取螺丝中的一个区分螺帽，将螺帽分成大堆和小堆，将匹配的螺帽去区分螺丝，将螺丝分成大堆小堆,
 *               将螺丝大堆和螺帽大堆相匹配,小堆和小堆匹配
 * @Data 2019/1/3
 */
public class Excercise2_3_15 {
    public static void main(String[] args) {
        // 螺丝
        int[] bolts = {5, 7, 6, 1, 3, 2, 9, 8, 4};
        // 螺帽
        int[] nuts = {1, 9, 5, 4, 8, 2, 7, 3, 6};
        match(bolts, nuts);
        ArrayUtil.printIntArray(bolts);
        ArrayUtil.printIntArray(nuts);
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

    private static int preSort(int pivot, int[] array, int lo, int hi) {
        // lt记录比排定的pivot小的指针
        int lt = lo, i = lo + 1;
        while (i <= hi) {
            // 将lt指针右移交换
            if (array[i] < pivot) ArrayUtil.exchange(array, i, ++lt);
            // 将相等对应的值挪到lo
            else if (array[i] == pivot) ArrayUtil.exchange(array, i--, lo);
            i++;
        }
        ArrayUtil.exchange(array, lt, lo);
        return lt;
    }
}
