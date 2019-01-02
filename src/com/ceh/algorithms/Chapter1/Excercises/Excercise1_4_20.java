package com.ceh.algorithms.Chapter1.Excercises;

/**
 * Created by enHui.Chen on 2019/1/1.
 */

import com.ceh.algorithms.Chapter1.BinarySearch.BinarySearch;

import java.util.Scanner;

/**
 * @Author: enHui.Chen
 * @Description: 双调查找
 * @Data 2019/1/1
 */
public class Excercise1_4_20 {
    public static void main(String[] args) {
        int[] array = {0, 1, 5, 6, 7, 18, 22, 22, 22, 42, 45, 49, 222, 222, 55, 44, 33, 11};
        int maxIndex = binarySearchGetMax(array, 0, array.length);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int val = scanner.nextInt();
            int index = BinarySearch.binarySearch(val, array, 0, maxIndex, true);
            index = index != -1 ? index : BinarySearch.binarySearch(val, array, maxIndex + 1, array.length, false);
            System.out.println(val + "的索引为:" + index);
        }
    }

    public static int binarySearchGetMax(int[] array, int lo, int hi) {
        if (hi == lo) return hi;
        int mid = lo + (hi - lo) / 2;
        if (array[mid] < array[mid + 1]) return binarySearchGetMax(array, mid + 1, hi);
        else return binarySearchGetMax(array, lo, mid);
    }
}
