package com.example.lib_arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/3 下午5:33
 * @Version: 1.0
 * @Description: 经典的快速排序  随机算法,最差情况是O(n^2) 期望算法时间复杂度O(nlogn)
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

    // 快速排序双路排序
    public static <E extends Comparable<E>> void sort2way(E[] arr) {
        Random ran = new Random();
        sort2way(arr, 0, arr.length - 1, ran);

    }

    private static <E extends Comparable<E>> void sort2way(E[] arr, int l, int r, Random ran) {
        if (l >= r) return;
        int partition = partition2(arr, l, r, ran);
        sort2way(arr, l, partition - 1, ran);
        sort2way(arr, partition + 1, r, ran);
    }

    //快速排序三路排序
    public static <E extends Comparable<E>> void sort3way(E[] arr) {
        Random ran = new Random();
        sort3way(arr, 0, arr.length - 1, ran);

    }

    /**
     * @param arr
     * @param l   左边开始下标
     * @param r   右边结束下标
     * @param ran 随机下标进行排序
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort3way(E[] arr, int l, int r, Random ran) {
        if (l >= r) return;
        int p = l + ran.nextInt(r - l + 1); // 获得一个随机下标进行比较
        swap(arr, l, p); //将随机下标的数据进行交换值l 的位置
        //arr[l+1,lt] < v arr[lt+1,i-1] == v arr[gt,r] > v
        int lt = l, i = l + 1, gt = r+1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) { // 小于 时 放在lt中
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) { // 大于是因为交换位置gt位置还未进行比较
                gt--;
                swap(arr, i, gt);
            } else { //arr[i] == arr[l]
                i++;
            }
        }
        swap(arr, l, lt); // 目前arr[l ,lt] < v arr[lt, gt-1] = v ,arr[gt,r] > v
        sort3way(arr, l, lt - 1, ran);//递归进行左边小于v的进行排序
        sort3way(arr, gt, r, ran); // 进行右边大于v的进行排序 中间相同的不需要处理

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
        int n = 10;
        Integer[] arr = ArrayGenerator.generatorRandomArr(n, n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
//        System.out.println("Random arr");
//        SortHelper.sortTest("quickSort", arr);
//        SortHelper.sortTest("quickSort2way", arr2);
//        SortHelper.sortTest("quickSort3way", arr3);
//        System.out.println();
//        arr = ArrayGenerator.generatorOrderedArray(n);
//        arr2 = Arrays.copyOf(arr, arr.length);
//        arr3= Arrays.copyOf(arr, arr.length);
//        System.out.println("order arr");
//        SortHelper.sortTest("quickSort", arr);
//        SortHelper.sortTest("quickSort2way", arr2);
//        SortHelper.sortTest("quickSort3way", arr3);
//        arr = ArrayGenerator.generatorRandomArr(n,1);
//        arr2 = Arrays.copyOf(arr, arr.length);
//        arr3 = Arrays.copyOf(arr, arr.length);
//        System.out.println("same arr");
////        SortHelper.sortTest("quickSort", arr);
//        SortHelper.sortTest("quickSort2way", arr2);
//        SortHelper.sortTest("quickSort3way", arr3);
        Integer[] nums = {2, 0, 2, 1, 1, 0};
//        System.out.println("color arr");
//        arr = ArrayGenerator.generatorRandomArr(10,100);
//        SortHelper.sortTest("quickSort3way", arr);

//        QuickSort.sort(arr);
//        SortHelper.sortTest("quickSort", arr);
//        QuickSort.sort2way(arr);
//        SortHelper.sortTest("quickSort2way", nums);
        QuickSort.sort3way(arr);
        for (Integer num : arr) {
            System.out.print(num+"->");
        }

    }
}
