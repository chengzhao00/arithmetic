package com.example.lib_arithmetic.sort;

import java.util.Random;

/**
 * @author:MR-Cheng
 * @date: 2020/8/22
 * @description: 生成一个 随机数为N 的长度 为 N的数组
 * @parameter:
 */
public class ArrayGenerator {
    private ArrayGenerator(){}

    public static Integer[] generatorOrderedArray(int n){
        Integer[] array = new Integer[n];
        for (int i = 0;i< n;i++){
            array[i] = i;
        }
        return array;
    }

    /**
     * 生成一个 无序数组
     * @param n
     * @param bound
     * @return
     */
    public static  Integer[] generatorRandomArr(int n,int bound){
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0 ; i < n;i++){
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
