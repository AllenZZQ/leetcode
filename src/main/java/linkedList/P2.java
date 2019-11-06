package linkedList;

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

            carry = sum > 9 ? 1 : 0;
            int val = sum > 9 ? sum - 10 : sum;
            current.next = new ListNode(val);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }


    public void test() {
    }

}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
