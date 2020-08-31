package com.example.lib_arithmetic.queue;


import com.example.lib_arithmetic.linked.LinkedList;


/**
 * @author:MR-Cheng
 * @date: 2020/8/29
 * @description: 使用链表实现队列操作
 * @parameter:
 */
public class LinkedListQueue<E> implements Queue<E> {
    public LinkedListQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }


        @Override
        public String toString() {
            return "Node{" + e.toString() + "}";
        }
    }

    private int size;
    private Node head,tail; // head 头结点，tail 尾节点

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
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("cannot deque from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null){
            tail = null;
        }
        size -- ;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("cannot deque from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("queue: head");
        Node cur = head;
        while (cur != null){
            stringBuilder.append(cur +"->");
            cur = cur.next;
        }
        stringBuilder.append("null - tail size = "+size);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> list = new LinkedListQueue<>();
        for (int i = 0 ; i < 5; i++){
            list.enqueue(i);
            System.out.println(list);
        }

        list.dequeue();
        System.out.println(list);
    }
}
