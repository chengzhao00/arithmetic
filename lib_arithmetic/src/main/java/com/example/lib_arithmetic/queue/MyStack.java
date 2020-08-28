package com.example.lib_arithmetic.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 下午6:06
 * @Version: 1.0
 * @Description:
 */
class MyStack {
    Queue<Integer> queue;
    private int top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while (queue.size() > 1){
            top = queue.peek(); // top 存储队尾元素以外的最后一个元素 即栈顶的新元素
            q2.add(queue.remove());
        }
        int ret = queue.remove();
        queue = q2;
        return ret;

    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */