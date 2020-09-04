package com.example.lib_arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/3 下午5:33
 * @Version: 1.0
 * @Description: 经典的快速排序
 */
public class QuickSort {

    private QuickSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random ran = new Random();
        sort(arr, 0, arr.length - 1, ran);

    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random ran) {
        if (l >= r) return;
        int partition = partition(arr, l, r, ran);
        sort(arr, l, partition - 1, ran);
        sort(arr, partition + 1, r, ran);
    }

    //获得partition位置
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        int j = l;
        swap(arr, p, l);
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }


    public static <E extends Comparable<E>> void sort2way(E[] arr) {
        Random ran = new Random();
        sort2way(arr, 0, arr.length - 1, ran);

    }

    private static <E extends Comparable<E>> void sort2way(E[] arr, int l, int r, Random ran) {
        if (l >= r) return;
        int partition = partition(arr, l, r, ran);
        sort2way(arr, l, partition - 1, ran);
        sort2way(arr, partition + 1, r, ran);
    }

    //获得partition位置
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, p, l);
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }


    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generatorRandomArr(n, n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println("Random arr");
        SortHelper.sortTest("quickSort", arr);
        SortHelper.sortTest("quickSort2way", arr2);
        System.out.println();
        arr = ArrayGenerator.generatorOrderedArray(n);
        arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println("order arr");
        SortHelper.sortTest("quickSort", arr);
        SortHelper.sortTest("quickSort2way", arr2);
    }
}
