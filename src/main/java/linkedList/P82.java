package linkedList;

import junit.framework.TestCase;

public class P82 extends TestCase {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        pre.next = cur;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;
            }
            cur = cur.next;
            pre.next = cur;
        }
        return dummy.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates2(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        }
    }

    public void test() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        deleteDuplicates(head);
    }


}
