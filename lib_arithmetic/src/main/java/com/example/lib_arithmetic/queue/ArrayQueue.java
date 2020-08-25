package com.example.lib_arithmetic.queue;

import com.example.lib_arithmetic.array.ArrayInfo;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 上午10:54
 * @Version: 1.0
 * @Description: 普通队列的dequeue 方法时间复杂度 为 O(n) 因为每次出队都会把所有的值挪动
 * 优化出循环队列
 */
public class ArrayQueue<E> implements Queue<E> {
    private ArrayInfo<E> arr;

    public ArrayQueue() {
        this.arr = new ArrayInfo<>();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        arr.addLast(e);
    }

    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.get(0);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array:size = " + getSize() + " ,capacity = " + arr.getCapacity() + "\n");
        sb.append("[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(arr.get(i));
            if (i != (getSize() - 1))
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
