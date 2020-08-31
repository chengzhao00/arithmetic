package com.example.lib_arithmetic.queue;

import java.util.Stack;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/26 上午11:29
 * @Version: 1.0
 * @Description:
 */
public class MyQueue {
    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> s2 = new Stack<>();
        while (!stack.empty()) {
            s2.push(stack.pop());
        }
        stack.push(x);
        while (!s2.empty()){
            stack.push(s2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        /**
         * Your MyQueue object will be instantiated and called as such:
         * MyQueue obj = new MyQueue();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.peek();
         * boolean param_4 = obj.empty();
         */
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */