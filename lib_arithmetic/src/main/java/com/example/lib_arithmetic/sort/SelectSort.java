package com.example.lib_arithmetic.sort;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/21 下午6:25
 * @Version: 1.0
 * @Description: 简单排序
 */
public class SelectSort {

    private SelectSort(){
    }

    /**
     * 选择排序
     * @param data 数组
     *  时间复杂度O(N^2)
     *
     */
    public static <E extends Comparable<E> > void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            // 获取第一个值
            int tempIndex = i;

            for (int j = i ;j < data.length;j++){

                if (data[j].compareTo(data[tempIndex]) < 0 ){
                    tempIndex = j;
                }
            }
            //交换位置
            E temp = data[i];
            data[i] = data[tempIndex];
            data[tempIndex] = temp;

        }
    }


    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generatorRandomArr(10,100);
        for (int i : arr){
            System.out.print(i+" ");
        }

    }
}
