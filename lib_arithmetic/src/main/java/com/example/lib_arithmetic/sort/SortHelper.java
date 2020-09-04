package com.example.lib_arithmetic.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author:MR-Cheng
 * @date: 2020/8/22
 * @description:
 * @parameter:
 */
public class SortHelper {
    private SortHelper() {

    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        double time = 0;
        if ("mergeSort".equals(sortName)){
            MergeSort.sort(arr);
        }else if ("quickSort".equals(sortName)){
            QuickSort.sort(arr);
        }else if  ("quickSort2way".equals(sortName)){
            QuickSort.sort2way(arr);
        }
        long endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println(time + "s");
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }


}
