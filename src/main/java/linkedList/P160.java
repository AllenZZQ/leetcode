package linkedList;

import java.util.HashSet;
import java.util.Set;

public class P160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int loop = 0;
        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            if (p2.next == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
            if (loop == 1) {
                p1 = p1.next;
            } else {
                if (p1.next == null) {
                    p1 = headB;
                    loop = 1;
                } else {
                    p1 = p1.next;
                }
            }
        }
        return null;
    }


}
