package tree;

import java.util.*;

/**
 * @see P102
 * @see P103
 */
public class P107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> deque = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>(deque);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            deque.addFirst(list);
        }
        return new ArrayList<>(deque);
    }

}
