package com.example.lib_arithmetic.linked;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/27 下午4:05
 * @Version: 1.0
 * @Description:
 */
public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表头部添加元素
    public void addHead(E e) {
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    //向指定位置添加元素
    //在链表中不是很常用的操作,练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index default failed");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    //向链表末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //遍历指定节点
    public E get(int index) {
        notEmpty(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getHead() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    public void set(int index ,E e){
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }


    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            stringBuilder.append(cur +"->");
            cur = cur.next;
        }
        stringBuilder.append("null - size = "+size);
        return stringBuilder.toString();
    }

    private void notEmpty(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index default failed");
        }
    }


    public E  remove(int index){
        notEmpty(index);
        Node preNode = dummyHead;
        for (int i =0 ; i < index; i++ ){
            preNode = preNode.next;
        }
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0 ; i < 5; i++){
            list.addHead(i);
            System.out.println(list);
        }
        list.add(2,100);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);


    }
}
