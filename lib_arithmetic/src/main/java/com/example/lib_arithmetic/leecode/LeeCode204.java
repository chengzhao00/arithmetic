package com.example.lib_arithmetic.leecode;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/7 下午5:54
 * @Version: 1.0
 * @Description: 二分查找法
 */
public class LeeCode204 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    //大于target的第一个解
    public static int searchUpper(int[] data, int target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return l;
    }


    public static int lowerCeil(int[] data,int target){
        int u = searchUpper(data,target);
        if (u+1 <data.length && data[u+1] == target){
            return u+1;
        }
        return u;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
//        searchUpper()
    }

}
