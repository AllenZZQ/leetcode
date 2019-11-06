package linkedList;

import junit.framework.TestCase;

public class P19 extends TestCase {

    /**
     * two pointer，两个指针间距保持为n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n >= 0) {
            fast = fast.next;
            n --;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


}