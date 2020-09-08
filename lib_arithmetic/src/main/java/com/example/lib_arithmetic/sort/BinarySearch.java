package com.example.lib_arithmetic.sort;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/7 下午4:51
 * @Version: 1.0
 * @Description: 二分查找法
 */
public class BinarySearch {

    private BinarySearch(){

    }
    /**
     * 非递归写法实现
     */
    public static <E extends Comparable<E>> int search(E[] data,E target){
        int l = 0,r = data.length -1;
        while (l <= r){
            int m = l + (r -l) /2;
            if(data[m].compareTo(target) == 0){
                return m;
            }
            if (data[m].compareTo(target) < 0){
                l = m + 1;
            }else{
                r = m -1;
            }
        }
        return -1;
    }

    /**
     *  递归写法实现二分查找法
     */
    public static <E extends Comparable<E>> int searchR(E[] data,E target){
        return searchR(data,0,data.length -1, target);
    }


    private static <E extends Comparable<E>> int searchR(E[] data,int l,int r,E target){
        if (l > r) return -1;
        int m  = l +( r - l ) /2;
        if (data[m].compareTo(target) == 0) {
            return m;
        }
        if (data[m].compareTo(target) < 0){
            return searchR(data,m+1,r,target);
        }
        return searchR(data,l, m -1,target);
    }

    public static void main(String[] args) {
    }
}
