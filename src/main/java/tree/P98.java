package tree;

import java.util.Stack;

public class P98 {

    // 先序
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    // 中序
    public boolean isValidBST2(TreeNode root) {
        inOrder(root);
        return result;
    }

    // 中序，非递归
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    private TreeNode pre = null;

    private boolean result = true;

    private void inOrder(TreeNode root) {
        if (root == null || !result) return;
        inOrder(root.left);
        if (pre != null && pre.val >= root.val) {
            result = false;
        }
        pre = root;
        inOrder(root.right);
    }


    // 先序遍历
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val<= lower) return false;
        if (upper != null && val >= upper) return false;
        return helper(root.left, lower, val) && helper(root.right, val, upper);
    }






}
