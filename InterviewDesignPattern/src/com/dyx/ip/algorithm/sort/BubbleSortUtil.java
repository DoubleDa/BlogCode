package com.dyx.ip.algorithm.sort;

/**
 * 冒泡排序(http://www.runoob.com/w3cnote/sort-algorithm-summary.html)
 */
public class BubbleSortUtil {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //临时变量
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * @param array
     * @function 数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
     */
    public static void bubbleSortOptimize(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //临时变量
        int temp;
        //是否交换的标志位
        boolean flag;
        for (int i = 0; i < array.length - 1; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
