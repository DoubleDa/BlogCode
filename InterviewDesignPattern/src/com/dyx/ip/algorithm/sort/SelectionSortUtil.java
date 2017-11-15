package com.dyx.ip.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSortUtil {
    public static void selectSort(int[] array, int length) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i) {
                int temp = array[i];
                array[i] = array[minValueIndex];
                array[minValueIndex] = temp;
            }
        }
    }
}
