package com.example.lib_arithmetic.stack;

import com.example.lib_arithmetic.array.ArrayInfo;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 上午10:28
 * @Version: 1.0
 * @Description:
 */
public class ArrayStack<E> implements Stack<E> {

    private ArrayInfo<E> arr;

    public ArrayStack(){
        arr = new ArrayInfo<>();
    }
    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E peek() {
        return arr.get(arr.getSize() -1);
    }

    @Override
    public boolean isEmpty() {
        return arr.getSize() == 0;
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }
}
