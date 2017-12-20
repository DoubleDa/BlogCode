package com.dyx.ip.algorithm.dyx;

public class MyAlgorithmNote {
    public static void main(String[] args) {
        int[] array = {23, 4, 56, 7, 12, 9, 82, 89, 39};
        /**
         * 1、冒泡排序
         */
        System.out.print(bubbleSort(array));
    }

    private static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] > array[i + 1]) {
                int temp;
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
