package linkedList;

import junit.framework.TestCase;

public class P147 extends TestCase {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0); // dummy.next 不能设置为head
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = dummy;
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public void test() {
        ListNode head = new ListNode(2);
        ListNode p = head;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);

        ListNode r = insertionSortList(head);
        System.out.println(1);
    }



}
