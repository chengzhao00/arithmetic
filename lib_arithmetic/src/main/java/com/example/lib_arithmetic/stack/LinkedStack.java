package com.example.lib_arithmetic.stack;

import com.example.lib_arithmetic.linked.LinkedList;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/28 下午2:53
 * @Version: 1.0
 * @Description: 用链表实现栈
 */
public class LinkedStack<E>  implements Stack<E>{

    private LinkedList<E> linkedList;
    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void push(E e) {
        linkedList.addHead(e);
    }

    @Override
    public E peek() {
        return linkedList.getHead();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }
}
