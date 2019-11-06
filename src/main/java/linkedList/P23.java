package linkedList;

import junit.framework.TestCase;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P23 extends TestCase {

    // k为数组个数，N为节点总数量
    /**
     * kN
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (hasVal(lists)) {
            int index = getMinNode(lists);
            ListNode l = lists[index];
            head.next = new ListNode(l.val);
            lists[index] = l.next;
            head = head.next;
        }
        return dummy.next;
    }

    private boolean hasVal(ListNode[] lists) {
        for (ListNode l : lists) {
            if (l != null) {
                return true;
            }
        }
        return false;
    }

    private int getMinNode(ListNode[] lists) {
        int m = 0;
        ListNode l = null;
        for (int i = 0; i < lists.length; i ++) {
            ListNode x = lists[i];
            if (x != null && (l == null || x.val < l.val)) {
                m = i;
                l = x;
            }
        }
        return m;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        // TODO zhaoziqiang 2019-10-29 优先队列，堆知识
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(x -> x.val));
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!queue.isEmpty()) {
            ListNode l = queue.poll();
            head.next = new ListNode(l.val);
            head = head.next;
            if (l.next != null) {
                queue.add(l.next);
            }
        }
        return dummy.next;
    }

    /**
     * 分治，最优解 Nlogk
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                point.next = new ListNode(a.val);
                a = a.next;
            } else {
                point.next = new ListNode(b.val);
                b = b.next;
            }
            point = point.next;
        }
        if (a != null) {
            point.next = a;
        }
        if (b != null) {
            point.next = b;
        }
        return dummy.next;
    }



    public void test_01() {

        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(-13));
        System.out.println(Integer.toBinaryString(-13 << 27));
        System.out.println(Integer.toBinaryString(-13 >>> 1));

        System.out.println(-13 << 27);
        System.out.println(-13 >>> 1);
    }


}
