package com.cyanogenmod.filemanager;

import java.util.Stack;

/**
 * @desribe :
 * Implement the following operations of a queue using stacks
 * 使用栈来实现队列
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 18-3-26.
 */

public class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!queue.empty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        while (!queue.empty()) {
            System.out.println(queue.peek());
            queue.pop();
        }
    }
}
