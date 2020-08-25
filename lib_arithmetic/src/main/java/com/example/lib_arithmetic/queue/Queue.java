package com.example.lib_arithmetic.queue;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 上午10:54
 * @Version: 1.0
 * @Description:
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);//向数组中添加元素

    E dequeue(); //删除队列中元素


     E getFront ();//返回队列首个对象

}
