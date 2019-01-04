package com.ceh.algorithms.Chapter1.Excercises;

import java.util.Scanner;

 /**
   * @Author: enHui.Chen
   * @Description: 返回指定元素的最小索引
   */
public class Excercise1_4_10 {

    public static void main(String[] args) {
        int[] array = {0, 1, 5, 6, 7, 18, 22, 22, 22, 42, 45, 49, 56, 65, 66, 66, 67, 76, 88, 99, 100, 222, 222};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int val = scanner.nextInt();
            int index = binarySearchGetMinIndex(val, array, 0, array.length - 1);
            System.out.println(val + "的最小索引为:" + index);
        }
    }

    public static int binarySearchGetMinIndex(int val, int[] array, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = (hi - lo) / 2 + lo;
        if (array[mid] == val) {
            int minIndex = binarySearchGetMinIndex(val, array, lo, mid - 1);
            return minIndex == -1 ? mid : minIndex;
        }
        if (array[mid] < val) return binarySearchGetMinIndex(val, array, mid + 1, hi);
        else return binarySearchGetMinIndex(val, array, lo, mid - 1);
    }
}
