package com.example.lib_arithmetic.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author:MR-Cheng
 * @date: 2020/8/22
 * @description:
 * @parameter:
 */
public class SortHelper {
    private SortHelper(){

    }

    public static <E extends Comparable<E>> void sortTest(Class<?> clazz,E[] arr) {
            long startTime = System.nanoTime();
            double time = 0;
//        try {
            Method[] methods = clazz.getMethods();
//            Method method = clazz.getMethod("sort",Object[].class);
//            method.invoke(null,arr);
//

//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        if (!SortHelper.isSorted(arr)){
//            throw  new RuntimeException("sort failed");
//        }
        try {

            for (Method method:methods){
                if ("sort".equals(method.getName())){
                    Type[] type =  method.getGenericParameterTypes();
                    System.out.println(" name = "+type[0].getTypeName());
                    method.invoke(null,(Object) arr);
                    long endTime = System.nanoTime();
                    time = (endTime - startTime) / 1000000000.0;
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (!SortHelper.isSorted(arr)){
            throw  new RuntimeException("sort failed");
        }
        System.out.println(time+"s");
    }

    /**
     * 判断数组是否有序
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length;i++){
            if (arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }


}
