package linkedList;

/**
 * 24题的进阶
 */
public class P25 {

    /**
     * 这边不用数组太麻烦了，牺牲空间换取易于理解的代码
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (true) {
            ListNode[] array = new ListNode[k];
            int i;
            for (i = 0; i < k && cur != null; i++) {
                array[i] = cur;
                cur = cur.next;
            }
            if (i < k) {
                break;
            }
            array[0].next = cur;
            for (i = 1; i < k; i++) {
                array[i].next = array[i - 1];
            }
            pre.next = array[k - 1];
            pre = array[0];
        }
        return dummy.next;
    }

    /**
     * 不用额外空间的方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (true) {
            ListNode r = reverse(cur, 1, k);
            if (r == cur) {
                break;
            }
            pre.next = r;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int m, int n) {
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



}
