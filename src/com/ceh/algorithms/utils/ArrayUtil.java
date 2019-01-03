package com.ceh.algorithms.utils;

/**
 * Created by enHui.Chen on 2019/1/2.
 */
public class ArrayUtil {

    public static void printIntArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i] + "]");
                return;
            }
            System.out.print(array[i] + ",");
        }
    }

    public static void exchange(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
