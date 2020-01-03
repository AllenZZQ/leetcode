package tree;

public class P110 {

    /**
     * 时间复杂度高，高度重复计算
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;
    }

    /**
     * 如果用boolean作为返回值，true-代表balance，则返回左右都是true时，并不知道高度，也就不知道root处是否balance
     * 所以用height，-1作为一个flag，当左右任何为-1时，直接返回-1，代表不平衡，否则返回高度
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return - 1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }




}
