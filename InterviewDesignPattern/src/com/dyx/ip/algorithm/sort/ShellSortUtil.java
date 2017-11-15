package com.dyx.ip.algorithm.sort;

/**
 * 希尔排序
 */
public class ShellSortUtil {
    public static void shellSort(int[] array, int length) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp = 0;
        int increase = length;
        while (true) {
            increase = increase / 2;
            //根据增量分为若干子序列
            for (int k = 0; k < increase; k++) {
                for (int i = k + increase; i < length; i += increase) {
                    for (int j = i; j > k; j -= increase) {
                        if (array[j] < array[j - increase]) {
                            temp = array[j - increase];
                            array[j - increase] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (increase == 1) {
                break;
            }
        }
    }
}
