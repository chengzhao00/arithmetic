package com.example.lib_arithmetic.sort;

import java.util.Arrays;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/1 下午3:33
 * @Version: 1.0
 * @Description: 归并排序
 */
public class MergeSort {
    private MergeSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)//判断如果是前面区间大于后面区间就是一个完全有序的数组,不需要重新合并
            merge(arr, l, mid, r);
    }

    //归并过程 合并两个有序区间 arr[l , mid] 和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//这个地方加1 是因为不包含最后一个元素
        int i = l, j = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort2(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort2(arr, l, mid, temp);
        sort2(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)//判断如果是前面区间大于后面区间就是一个完全有序的数组,不需要重新合并
            merge2(arr, l, mid, r, temp);
    }

    //归并过程 合并两个有序区间 arr[l , mid] 和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r, E[] temp) {
//        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//这个地方加1 是因为不包含最后一个元素
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {
//        Integer[] arr = ArrayGenerator.generatorRandomArr(10, 100);

        Integer[] arr = new Integer[]{233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.print(" length -> " + arr.length);
        System.out.println();
        MergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println();
        MergeSort.sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.print(" length -> " + arr.length);

    }

    /**
     * leedcode 52 号 题 求数组中逆数数对
     */
    static class Solution {
        private static int res;
        public int reversePairs(int[] nums) {
            int[] temps = new int[nums.length];
            res = 0;
            sort(nums,0,nums.length-1,temps);
            return res;
        }

        public static void main(String[] args) {
            int[] nums = {233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};
            int[] temps = new int[nums.length];

            sort(nums,0,nums.length-1,temps);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + "->");
            }

        }

        private  static void sort(int[] arr,int l,int r,int[] temps){
            if(l >= r) return;
            int mid = l + (r -l) /2;
            sort(arr,l,mid,temps);
            sort(arr,mid+1,r,temps);
            if(arr[mid] > arr[mid+1]){
                merge(arr,l,mid,r,temps);
            }
        }

        private  static void merge(int[] arr,int l , int mid,int r, int[] temps){
            System.arraycopy(arr,l,temps,l,r-l+1);
            int i = l, j = mid+1;
            for(int k = l;k <= r;k++){
                if(i > mid){
                    arr[k] = temps[j];
                    j++;
                }else if(j > r){
                    arr[k] = temps[i];
                    i++;
                }else if(temps[i] <= temps[j]){
                    arr[k] = temps[i];
                    i++;
                }else{
                    res += mid - i +1;
                    arr[k] = temps[j];
                    j++;
                }
            }
        }
    }
}
