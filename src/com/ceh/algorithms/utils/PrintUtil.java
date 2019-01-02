package com.ceh.algorithms.utils;

/**
 * Created by enHui.Chen on 2019/1/2.
 */
public class PrintUtil {

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

}
