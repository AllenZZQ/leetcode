package tree;

import junit.framework.TestCase;

import java.util.*;

/**
 * @see P102
 */
public class P103 extends TestCase {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (flag == 0) {
                    deque.addLast(t.val);
                } else {
                    deque.addFirst(t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            flag = flag ^ 1;
            result.add(new ArrayList<>(deque));
        }
        return result;
    }

    public void test() {
        boolean f = false;
        System.out.println(f ^ true);
    }


}
