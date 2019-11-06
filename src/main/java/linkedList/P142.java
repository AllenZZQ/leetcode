package linkedList;

import junit.framework.TestCase;

/**
 * 链表有环问题，找到环的起点
 *
 * 设慢指针走了k步，快指针走了2k步，环的长度为r，则 2k - k = nr -> k = nr
 * 设环起点距离起点s，环起点距离指针相遇处t，则s + t = k -> t + s = nr，
 * 即从指针相遇出移动s步，会绕着环转n圈，即最后会在环的起点处
 * 所以两个指针，一个从起点出发，一个从位置k出发，最后在环起点相遇
 */
public class P142 extends TestCase {


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void test() {

        ListNode head = new ListNode(3);
        ListNode dummy = head;

        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(0);
        head = head.next;
        head.next = new ListNode(-4);
        head = head.next;
        head.next = dummy.next;

        System.out.println(detectCycle(dummy).val);
    }


}
