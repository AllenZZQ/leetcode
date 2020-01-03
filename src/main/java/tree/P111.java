package tree;

public class P111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (leftMin == 0 || rightMin == 0) return leftMin + rightMin + 1;
        return Math.min(leftMin, rightMin) + 1;
    }


}
