package com.example.lib_arithmetic.leecode;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/1 上午9:47
 * @Version: 1.0
 * @Description: 反转一个单链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReceiverLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    static class Solution {
        /**
         * 非递归实现反转链表
         * 解题思路为  null <-1 <- 2 <- 3 <-4 <- 5
         * @param head
         * @return
         */
//        public ListNode reverseList(ListNode head) {
//            ListNode pre,cur,next;
//            pre = null;
//            cur = head;
//            while(cur != null){
//                next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            }
//            return pre;
//        }

        /**
         * 尾节点递归方式实现反转链表
         *
         * @param head
         * @return
         */

//        public ListNode reverseList(ListNode head) {
//           return reverseList(null,head);
//        }
//
//        private ListNode reverseList(ListNode pre,ListNode cur){
//            if (cur == null) return pre;
//            ListNode next = cur.next;
//            cur.next = pre;
//            return reverseList(cur,next);
//        }
        /**
         * 第二种递归方式反转链表
         */

        public ListNode reverseList(ListNode head){
            if (head == null || head.next == null)
                return head;
            ListNode rev = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return rev;
        }



        /**
         * 返回倒数第k个节点
         * @param head
         * @param k
         */

        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            for(int i  = 0 ; i < k; i++){
                fast = fast.next;
            }
            ListNode low = head;
            while(fast!=null){
                fast = fast.next;
                low = low.next;
            }
            return low.val;
        }

        public static void main(String[] args) {
//           ListNode node;
//            for (int i = 0 ; i < 10; i ++){
//                node = new ListNode(i,node.next);
//            }
        }

//        private int kthToLast(ListNode head,int k ,int index){
//
//        }
    }
}
