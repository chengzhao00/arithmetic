package com.example.lib_arithmetic.leecode;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/8 下午6:21
 * @Version: 1.0
 * @Description: 1011 D天内送达包裹的能力
 */
public class LeetCode1011 {
    class Solution {
        //TODO 明天开始二分
        public int shipWithinDays(int[] weights, int D) {
            /**
             *  如果D天运送完 每天的最低承载量是 sum / D
             *  但是每天只允许运送一个包裹 最低的承载量为  Math.max(sum / D,weights[i])
             *  最高承载量为sum所有包裹的总重量
             */
            int max = 0;
            int sum = 0;


            for (int i = 0; i < weights.length; i++) {
                sum += weights[i];
                max = Math.max(weights[i], max);
            }
            int l = Math.max(sum / D, max), r = sum;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (day(weights, m) <= D) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }

        // k 为每次运输重量 返回day 天数
        private int day(int[] weights, int k) { // 求出天数
            int res = 0;
            int day = 0;
            for (int i = 0; i < weights.length; i++) {
                if (res + weights[i] > k) {
                    day++;
                    res = 0;
                    // break;
                } else {
                    res += weights[i];
                }
            }
            return day;
        }
    }
}
