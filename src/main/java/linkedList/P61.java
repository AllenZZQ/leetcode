package linkedList;

import junit.framework.TestCase;

public class P61 extends TestCase {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode l2 = head;
        for (; l2.next != null; l2 = l2.next) {
            length++;
        }

        if (k % length == 0) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        for (int i = 1; i < length - (k % length); i ++) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = null;
        l2.next = head;

        return p2;
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

       rotateRight(head, 2);

//        System.out.println(JSON.toJSONString(head.val));
    }

    public void test_01() {
        System.out.println(5 - 2 % 5);
    }


}
