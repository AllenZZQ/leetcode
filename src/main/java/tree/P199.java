package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199 {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode n = queue.poll();
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
                if (i == size - 1) {
                    result.add(n.val);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    /**
     * 先序遍历，从右往左
     * @param root
     * @param list
     * @param level
     */
    private void helper(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(root.val);
        }
        helper(root.right, list, level + 1);
        helper(root.left, list, level + 1);
    }







}
