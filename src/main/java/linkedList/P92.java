package linkedList;

import junit.framework.TestCase;

public class P92 extends TestCase {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode slow = null;
        int i;
        for (i = 0; i < m && cur != null; i++) {
            slow = pre;
            pre = cur;
            cur = cur.next;
        }
        if (i < m) {
            return head;
        }
        ListNode c = cur;
        for (i = 0; i < n - m && c != null; i++) {
            c = c.next;
        }
        if (i < n - m) {
            return head;
        }

        ListNode p = pre;
        for (i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p.next = cur;
        slow.next = pre;
        return dummy.next;
    }


    public void test() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);

        ListNode n = reverseBetween(head, 2, 4);
    }


}
