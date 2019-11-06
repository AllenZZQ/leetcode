package linkedList;

public class P83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        pre.next = cur;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }


}
