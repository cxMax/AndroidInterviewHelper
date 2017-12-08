package com.meizu.thirdparty;

/**
 * @describe : 在一个已排序的链表里满, 去重
 *             输出 : 不含重复元素的链表
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-8.
 */

public class RemoveDuplicateFromSortedLink {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        while (slow.next != null) {
            if (slow.val == slow.next.val) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }
        }

        return head;
    }

}
