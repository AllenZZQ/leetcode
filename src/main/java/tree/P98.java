package tree;

public class P98 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
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
