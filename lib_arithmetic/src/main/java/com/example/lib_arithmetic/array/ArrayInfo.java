package com.example.lib_arithmetic.array;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/21 下午5:34
 * @Version: 1.0
 * @Description: 数据结构和算法 - 维护一个自己的数组
 */
public class ArrayInfo {

    private int[] data;
    private int size;

    public ArrayInfo(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public ArrayInfo(){
        this(10);
    }


    public boolean isEmpoty(){
        return size == 0;
    }
}
