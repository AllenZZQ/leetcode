package tree;

import junit.framework.TestCase;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Traversal extends TestCase {

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node != null) {
                System.out.println(node.val);
                deque.addFirst(node.right);
                deque.addFirst(node.left);
            }
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public void inOrder2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.addFirst(cur);
                cur = cur.left;
            }
            cur = deque.removeFirst();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public void test() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
    }

}
