package com.example.lib_arithmetic;

import com.example.lib_arithmetic.queue.ArrayQueue;
import com.example.lib_arithmetic.queue.LoopQueue;
import com.example.lib_arithmetic.queue.Queue;

import java.util.Random;

public class Test {

    private static double testQueue(Queue<Integer> queue, int optCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < optCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        int optCount = 100000;
//        double  arrtime = testQueue(new ArrayQueue<Integer>(),optCount); //测试数组队列的时间复杂度
//        double loopTime = testQueue(new LoopQueue<Integer>(),optCount); // 测试循环队列的时间复杂度
//        System.out.println(arrtime);
//        System.out.println(loopTime);
        int[] nums = {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + "->");
        }
    }


    static class Solution {

        public void sortColors(int[] nums) {
            Random ran = new Random();
            sort(nums, 0, nums.length -1, ran);
        }

        private void sort(int[] nums, int l, int r, Random random) {
            if (l >= r) return;
            int p = l + random.nextInt(r - l + 1);//生成一个随机数作为v
            swap(nums, l, p); //将随机数放置第一个位置
            int lt = l, i = l + 1 , gt = r +1; // i 代表当前元素 lt 代表左边元素 gt 代表右边比较元素
            while (i < gt) {
                if (nums[i] < nums[l]) {
                    lt++;
                    swap(nums, i, lt);
                    i++;
                } else if (nums[i] > nums[l]) { // 这个地方不进行i++ 是因为位置交换之后原来gt位置元素还没有进行比较
                    gt--;
                    swap(nums, i, gt);
                } else {
                    i++;
                }

            }
            swap(nums, l, lt);
            sort(nums, l, lt - 1, random);
            sort(nums, gt, r, random);
        }

        private void swap(int[] nums, int i, int j) { // 进行数组中两个位置的交换
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

}