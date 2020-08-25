package com.example.lib_arithmetic.stack;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 上午10:19
 * @Version: 1.0
 * @Description:
 */
interface Stack<E> {

    E pop();

    void push(E e);

    E peek();

    boolean isEmpty();

    int getSize();

}
