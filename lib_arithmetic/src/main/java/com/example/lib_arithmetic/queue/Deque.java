package com.example.lib_arithmetic.queue;
/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 下午4:54
 * @Version: 1.0
 * @Description:
 */
public class Deque<E> implements Queue<E> {
    private int size;
    private int front, tail;
    private E[] data;

    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
    }

    public Deque() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        addLast(e);
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    public void addFront(E e) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        front = front == 0 ? data.length -1 : front -1;
        data[front] = e;
        size++;
    }

    public void addLast(E e) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    public void removeFront() {

    }

    public void removeLast() {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deque:size = " + size + " ,capacity = " + data.length + "\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail)
                sb.append(", ");
        }
        sb.append("] deque");
        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++){
            deque.enqueue(i);
            System.out.println(deque);
        }
        deque.addFront(100);
        System.out.println(deque);
    }
}
