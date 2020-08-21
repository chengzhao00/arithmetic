package com.example.test;

import java.util.Stack;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/20 上午10:46
 * @Version: 1.0
 * @Description:
 */
public class StaicUtils {

    class Node {
        int data;
        Node next;
    }


    //删除链表中倒数第k个几点
    public void deleteKNode(Node head,int k){

    }

    //单链表删除指定节点
    public void deleteNode(Node head, Node node) {
        if (node.next == null) {
            while (head.next != null) {
                if (head.next != node) {
                    head = head.next;
                }
                head.next = null;
            }
        } else if (head == node) {
            head.next = null;
        } else {
            Node n = node.next;
            node.data = n.data;
            node.next = n.next;
        }
    }

    //单链表中删除指定value节点 利用stack
    public Node deleteValStack(Node head, int val) {

        Stack<Node> stacks = new Stack<>();
        while (head != null) {
            if (head.data != val) {
                stacks.push(head);
            }
            head = head.next;
        }
        while (!stacks.empty()) {
            stacks.peek().next = head;
            head = stacks.pop();
        }
        return head;

    }

    //单链表中删除指定value 节点 不利用stack

    public Node deleteValNode(Node head, int val) {
        while (head != null) {
            if (head.data != val) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }


    //冒泡排序

    public void bubblingSort(int[] nums) {
        int temp;
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
