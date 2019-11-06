package linkedList;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class P138 extends TestCase {

    public Node copyRandomList(Node head) {
        Map<Node, Node> old2New = new HashMap<>();
        Node dummy = new Node();
        Node p1 = dummy;
        while (head != null) {
            Node c = new Node();
            c.val = head.val;
            p1.next = c;
            old2New.put(head, c);
            p1 = p1.next;
            head = head.next;
        }

        old2New.forEach((k, v) -> v.random = old2New.get(k.random));

        return dummy.next;
    }

    /**
     * 不需要而外space，且速度更快的方法
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node next = p.next;
            Node copy = new Node();
            copy.val = p.val;
            copy.next = next;
            p.next = copy;
            p = next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;

        Node dummy = new Node();
        Node q = dummy;
        while (p != null) {
            Node next = p.next.next;
            q.next = p.next;
            p.next = next;
            p = next;
            q = q.next;
        }
        return dummy.next;

    }

    public void test() {
        Node a = new Node();
        Node b = new Node();
//        Node c = new Node();
        a.val = 1;
        b.val = 2;
//        c.val = 3;
        a.next = b;
        a.random = b;
        b.random = b;
//        b.next = c;
//        a.random = c;
//        c.random = a;
        copyRandomList2(a);
    }





}


class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
