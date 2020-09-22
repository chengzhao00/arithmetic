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

    // < target 的最大值的索引
    public static int searchLower(int[] data,int target){
        int l = -1, r = data.length;
        while (l < r){
            int  m = l + (r - l + 1) / 2;// 这个地方 加一是为了防止左边界l == mid
            if (data[m] < target){
                l = m;
            }else{
                r = m -1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
//        searchUpper()
        for (int i =0 ; i <=6; i ++){
            System.out.print(searchLower(arr,i)+" ->");
        }
    }

}
