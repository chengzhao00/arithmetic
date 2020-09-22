package com.example.lib_arithmetic.leecode;

import java.util.Arrays;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/8 下午4:48
 * @Version: 1.0
 * @Description:
 */
public class LeetCode875 {
    static class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int l = 1, r = Arrays.stream(piles).max().getAsInt(); // 获取数组中最大值
            while (l < r){
                int mid = l + (r - l) /2;
                if (eatingTime(piles,mid) <= H){
                    r = mid ;
                }else{
                    l = mid +1;
                }
            }
            return l;

        }

        private int eatingTime(int[] piles,int k){
            int res = 0;
            for (int i = 0 ; i < piles.length; i++){
                res += piles[i] / k + (piles[i] % k > 0 ? 1 : 0 );
            }
            return res;
        }
    }
}
