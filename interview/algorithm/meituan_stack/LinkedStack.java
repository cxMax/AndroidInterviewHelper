package com.cxmax.test1;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/10.
 */

public class LinkedStack {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode top;

    public int pop(){
        int result = top.val;
        if (top.next != null) {
            top = top.next;
        }
        return result;
    }

    public void push(int element){
        top = new ListNode(element, top);
    }

    public int peek(){
        int result = top.val;
        return result;
    }
}
