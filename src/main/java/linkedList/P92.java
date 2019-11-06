package linkedList;

import junit.framework.TestCase;

public class P92 extends TestCase {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode pre = head;
        ListNode cur = head.next;
        for (; m > 1; m--, n--) {
            cur = cur.next;
            pre = pre.next;
            p = p.next;
        }
        for (; n > 1; n --) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        p.next.next = cur;
        p.next = pre;
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
