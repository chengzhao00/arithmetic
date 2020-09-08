package com.example.lib_arithmetic.leecode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/7 上午11:21
 * @Version: 1.0
 * @Description:
 */
public class Leecode215 {


    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Random ran = new Random();
            int sort = sort(nums,nums.length - k,0,nums.length -1 ,ran);
            for (int i = 0; i < nums.length; i++){
                System.out.println(nums[i]+"->");
            }
            System.out.println(sort);
            return sort;
        }

        private int sort(int[] nums,int k,int l , int r,Random ran){
            int p = partition(nums,l,r,ran);
            if(k == p){
                return nums[k];
            }
            if(k < p){
                return sort(nums,k,l, p -1,ran);
            }
            return sort(nums,k,p+1,r,ran);
        }

        private int partition(int[] nums,int l, int r,Random ran){
            int p = l + ran.nextInt(r - l +1);
            swap(nums,l,p);
            int i = l+1,j = r;
            while(true){
                while(i <= j && nums[i] < nums[l]){
                    i++;
                }
                while(j >= i && nums[j] > nums[l]){
                    j--;
                }
                if(i >= j) break;
                swap(nums,i,j);
                i++;
                j--;
            }
            swap(nums,l,j);
            return j;
        }


        private void swap(int[] nums,int i ,int j){
            int p = nums[i];
            nums[i] = nums[j];
            nums[j] = p;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,4,3,3,3,3};
       int l =  new Solution().findKthLargest(nums,2);
        System.out.println("k === "+l);
    }


}
