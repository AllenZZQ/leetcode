package tree;

import java.util.ArrayList;
import java.util.List;

public class P114 {

    /**
     * 最直接的，获取所有的值，然后组成树
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        TreeNode head = root;
        root.left = null;
        root.right = null;
        for (int i = 1; i < list.size(); i ++) {
            head.right = new TreeNode(list.get(i));

            head = head.right;
        }
    }

    private TreeNode pre;

    /**
     * 从最简单的有一个左子树和右子树的情形去验证
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }


    private void traversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            traversal(root.left, list);
            traversal(root.right, list);
        }
    }


}
