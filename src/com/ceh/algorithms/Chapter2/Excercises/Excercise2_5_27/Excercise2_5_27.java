package com.ceh.algorithms.Chapter2.Excercises.Excercise2_5_27;

import com.ceh.algorithms.utils.ArrayUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: enHui.Chen
 * @Description: 平行数据排序
 */
public class Excercise2_5_27 {

    @Test
    public void directSortTest() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(49) + 1;
        }
        ArrayUtil.printIntArray(arr);
        int[] indexArr = new Insertion().indirectSort(arr);
        for (int index : indexArr) {
            System.out.println(index + "(" + arr[index] + ")");
        }
    }
}
