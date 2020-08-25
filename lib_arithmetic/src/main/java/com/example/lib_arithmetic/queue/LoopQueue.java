package com.example.lib_arithmetic.queue;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 下午2:18
 * @Version: 1.0
 * @Description:
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }


    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1]; // 扩容时将原来的数据放在新的数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length]; // 将[0...size]的时候重新放入数组
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("don't empty");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return null;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw  new NullPointerException("data don't null");
        return data[front];
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:size = " + size + " ,capacity = " + data.length + "\n");
        sb.append("[");
        for (int i = front; i != tail; i = (i +1) % data.length) {
            sb.append(data[i]);
            if ((i + 1)% data.length != tail)
                sb.append( ", ");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0 ; i < 20; i++){
            queue.enqueue(i);
            if (i % 3 == 2){
                queue.dequeue();
            }
            System.out.println(queue);
        }

        for (int i = 0; i < 10; i++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}