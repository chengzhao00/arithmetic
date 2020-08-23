package com.example.lib_arithmetic.sort;

/**
 * @author:MR-Cheng
 * @date: 2020/8/22
 * @description: 插入排序
 * @parameter:
 * 插入排序和选择排序法时间复杂度都是O(n^2)
 * 再一个有序数组插入算法时间复杂度都是O(n)
 * 但是插入排序比选择排序的优势是在同一个有序数组的表现插入排序比选择排序会好很多
 */
public class InsertSort {
    private InsertSort(){

    }

    public static <E extends Comparable<E>>  void sort(E[] data){

//        for (int i = 0; i < data.length; i++){
//            //将data[i] 插入指定位置
//            for (int j = i; j -1  >= 0; j --){
//                //如果data[]
//                if (data[j].compareTo(data[j - 1]) < 0){
//                    E temp = data[j];
//                    data[j] = data[j -1];
//                    data[j -1] = temp;
//                }else{
//                    break;
//                }
//            }
//
//        }
    // 插入排序进行优化，优化之后 有序数组的排序 O（n）
        for (int i = 0; i < data.length; i++){
            E t = data[i]; // 获取第i 个值
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(data[j-1])< 0; j--){
                data[j] = data[j -1];
            }
            data[j] = t;
        }
    }


    public static void main(String[] args) {
//        int[] arr = {10000,100000};
//        for (int i : arr) {
//            Integer[] intTemp = ArrayGenerator.generatorRandomArr(i,i);
////            SortHelper.sortTest(InsertSort.class,intTemp);
//            InsertSort.sort(intTemp);
//            boolean issort = SortHelper.isSorted(intTemp);
//            System.out.println(issort+" ===");
//        }
            Integer[] intTemp = ArrayGenerator.generatorRandomArr(10,10);
//            SortHelper.sortTest(InsertSort.class,intTemp);
            InsertSort.sort(intTemp);
            boolean issort = SortHelper.isSorted(intTemp);
            System.out.println(issort+" ===");
            for (int i:intTemp){
                System.out.print(i+" ");
            }


    }
}
