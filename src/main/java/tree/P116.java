package tree;

import java.util.LinkedList;
import java.util.Queue;

public class P116 {

    /**
     * level traversal
     * @param root
     * @return
     */
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

    public Node connect2(Node root) {
        if (root == null) return root;
        Node cur = root;
        while (cur.left != null) {
            Node temp = cur;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            cur = cur.left;
        }
        return root;
    }




}
