package com.dyx.ip.algorithm.sort;

/**
 * 插入排序
 */
public class InsertSortUtil {
    public static void insertSort(int[] array, int length) {
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
