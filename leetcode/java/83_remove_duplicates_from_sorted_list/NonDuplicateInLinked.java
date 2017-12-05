/**
 * @describe : 链表去除重复元素
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/5.
 */

public class NonDuplicateInLinked {

     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplicates(ListNode head) {
         if (head == null) {
             return head;
         }
         ListNode list = head;
         while (list != null) {
             if (list.next == null) {
                 break;
             }
             if (list.val == list.next.val) {
                 list.next = list.next.next;
             } else {
                 list = list.next;
             }
         }
        return list;
    }

    public static void main(String[] args) {

    }
}
