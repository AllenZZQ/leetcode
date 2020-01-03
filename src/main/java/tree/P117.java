package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see P116
 * 和116题的区别是116题是perfect binary tree
 */
public class P117 {

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node = null;
            for (int i = 0; i < size; i ++) {
                Node n = queue.poll();
                if (node != null) {
                    node.next = n;
                }
                node = n;
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        return root;

    }
}
