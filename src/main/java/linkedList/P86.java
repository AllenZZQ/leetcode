package linkedList;

public class P86 {

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode above = new ListNode(0);
        ListNode p = less;
        ListNode q = above;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = above.next;
        return less.next;

    }


}
