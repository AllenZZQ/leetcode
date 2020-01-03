package tree;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P173 extends TestCase {

    public void test() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.push(3);
        System.out.println(deque.pop());
    }
}


class BSTIterator {

    private List<Integer> list;

    private int size;

    private int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        size = list.size();
        index = 0;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index ++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < size;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}