package com.example.lib_arithmetic.array;


/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/21 下午5:34
 * @Version: 1.0
 * @Description: 数据结构和算法 - 维护一个自己的数组
 */
public class ArrayInfo<E> {

    private E[] data;
    private int size;

    public ArrayInfo(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayInfo() {
        this(10);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //获取size大小
    public int getSize() {
        return size;
    }

    //获取数组容量的大小
    public int getCapacity() {
        return data.length;
    }

    //在最后一个位置添加 准确的说是O(1) 但是程序要考虑的是极端情况
    public void addLast(E e) {
        add(size, e);
    }

    //在第一个位置添加
    public void addFirst(E e) {
        add(0, e);
    }

    //向指定位置添加元素 时间复杂度 O(n)
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed index error");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed index error");
        }
        return data[index];
    }

    //替换 数组中 e的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed index error");
        }
        data[index] = e;
    }

    //查询数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找数组中为 e的索引 如果有返回索引,若果没有返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除数组中index 的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed index error");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //这样写是为了防止复杂度震荡因为频繁调用 resize方法他的时间复杂度一直都是O(n) 当为1/4 时进行减少, 1/2 的内存
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 对数组进行扩容每次扩容2倍 均摊复杂度 O(1) 遭遇特殊复杂度的情况下会发生复杂度震荡
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array:size = " + size + " ,capacity = " + data.length + "\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size-1)
            sb.append( ", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
