package com.example.lib_arithmetic.leecode;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/31 上午11:33
 * @Version: 1.0
 * @Description: 使用递归求数组的和
 */
public class ArraySum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr, int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
