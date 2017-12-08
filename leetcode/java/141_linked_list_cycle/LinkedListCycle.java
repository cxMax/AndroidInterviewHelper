package com.meizu.thirdparty;

import java.util.List;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-7.
 */

public class LinkedListCycle {

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // Given a linked list, determine if it has a cycle in it.
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode walker = head;
        ListNode runner = head;

        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    // Given a linked list, return the node where the cycle begins. If there is no cycle, return null
    public ListNode detechCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}
