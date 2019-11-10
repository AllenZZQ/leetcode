package linkedList;

import junit.framework.TestCase;

public class Util extends TestCase {

    /**
     * 获取一个node的中间
     *
     * @param head
     * @return
     */
    public static ListNode middle(ListNode head, boolean cut) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (cut && pre != null) {
            pre.next = null;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverse(ListNode head, int m, int n) {
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

        for (i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next.next = cur;
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

        ListNode n = reverse(head.next, 2, 3);
        System.out.println(n);
    }


}
