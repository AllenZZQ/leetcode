package linkedlist;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class P2 extends TestCase {

    public ListNode solution(ListNode l1, ListNode l2) {
        // 巧妙的设置一个头
        ListNode dummyHead = new ListNode(0);
        ListNode tempNode = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            tempNode.next = new ListNode(sum % 10);
            tempNode = tempNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            tempNode.next = new ListNode(1);
        }
        // 返回头节点的next
        return dummyHead.next;
    }


    // region test
    public void test() {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = solution(l1, l2);

        Assertions.assertThat(l3.val).isEqualTo(7);
        Assertions.assertThat(l3.next.val).isEqualTo(0);
        Assertions.assertThat(l3.next.next.val).isEqualTo(8);
    }
    // endregion
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        super();
        this.val = val;
    }
}