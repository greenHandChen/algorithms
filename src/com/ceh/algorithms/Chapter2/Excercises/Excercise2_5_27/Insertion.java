package com.ceh.algorithms.Chapter2.Excercises.Excercise2_5_27;

import com.ceh.algorithms.utils.ArrayUtil;

/**
 * Created by enHui.Chen on 2019/1/17.
 */
public class Insertion {

    public int[] indirectSort(int[] arr) {
        int[] indexArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexArr[i] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[indexArr[j]] < arr[indexArr[j - 1]]) {
                    ArrayUtil.exchange(indexArr, j, j - 1);
                }
            }
        }
        return indexArr;
    }
}
