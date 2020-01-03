package stack;

import junit.framework.TestCase;

public class P155 extends TestCase {

    public void test() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
    }
}


class MinStack {

    public static void main(String[] args) {
    }

    private Node head;

    private class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }


    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        Node n;
        if (head == null) {
            n = new Node(x, x);
        } else {
            n = new Node(x, Math.min(x, head.min));
        }
        n.next = head;
        head = n;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}