package linkedlist;

import junit.framework.TestCase;


public class P2 extends TestCase {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            int sum = x1 + x2 + carry;
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }


    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next;
        n2 = new ListNode(-1);
        System.out.println(n1.next.val);
    }

}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
