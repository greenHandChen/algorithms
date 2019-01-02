package com.ceh.algorithms.Chapter1.BinarySearch;

/**
 * Created by enHui.Chen on 2018/12/31.
 */
public class BinarySearch {

    public static int binarySearch(int val, int[] array, int lo, int hi, boolean isAsc) {
        if (hi < lo) return -1;
        int mid = (hi - lo) / 2 + lo;
        if (array[mid] == val) return mid;
        if (isAsc) {
            if (array[mid] < val) return binarySearch(val, array, mid + 1, hi, isAsc);
            else return binarySearch(val, array, lo, mid - 1, isAsc);
        } else {
            if (array[mid] < val) return binarySearch(val, array, lo, mid - 1, isAsc);
            else return binarySearch(val, array, mid + 1, hi, isAsc);
        }
    }
}
