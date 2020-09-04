package com.example.lib_arithmetic.linked;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/27 下午4:05
 * @Version: 1.0
 * @Description: 使用递归实现链表
 */
public class LinkedList2<E> {

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

    private Node head;
    private int size;

    public LinkedList2() {
        head = null;
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
        add(0,e);
    }

    //向指定位置添加元素
    //在链表中不是很常用的操作,练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index default failed");
        }
        head = add(head,index,e);
        size++;
    }

    private Node add(Node node,int index,E e){
        if (index == 0){
            return new Node(e,node);
        }
        node.next = add(node.next,index -1,e);
        return node;
    }

    //向链表末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //遍历指定节点
    public E get(int index) {

        return get(head,index);
    }

    private E get(Node node,int index){
        if (index == 0){
            return node.e;
        }
        return  get(node.next,index -1);
    }

    public E getHead() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    public void set(int index ,E e){
       set(head,index,e);
    }

    private void set(Node node,int index, E e){
        if (index == 0){
            node.e = e;
            return ;
        }
        set(node.next,index - 1,e);
        return ;
    }


    public boolean contains(E e){
        return contains(e);
    }

    private boolean contains(Node node,E e){
        if (node == null) return false;
        if (node.e.equals(e)){
            return true;
        }
        return contains(node.next,e);
    }


    public void reverseList(){
        head = reverseList(head);
    }

    private Node reverseList(Node node){
        if (node == null || node.next == null){
            return node;
        }
        Node  pre  = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return pre;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = head;
        while (cur != null){
            stringBuilder.append(cur +"->");
            cur = cur.next;
        }
        stringBuilder.append("NULL - size = ");
        return stringBuilder.toString();
    }

    private void notEmpty(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index default failed");
        }
    }


    public E  remove(int index){
        notEmpty(index);
        Node preNode = head;
        for (int i =0 ; i < index; i++ ){
            preNode = preNode.next;
        }
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    private Node remove(Node node,int index){
        if (node == null){
            return null;
        }
        if (index == 0){
            node.next = remove(node.next,index);
        }
        return node;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    public static void main(String[] args) {
        LinkedList2<Integer> list = new LinkedList2<>();
        for (int i = 0 ; i < 5; i++){
            list.addHead(i);
        }
        list.add(2,100);
        list.addLast(100);
        System.out.println(list);

        System.out.println(list.getHead());
        System.out.println(list.get(2));
        System.out.println(list.getLast());
        list.set(2,120);
        System.out.println(list);
        list.reverseList();
        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        System.out.println(list.removeFirst());
//        System.out.println(list.removeLast());
//        System.out.println(list);


    }
}
