package tree;

import junit.framework.TestCase;

public class P112 extends TestCase {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public void test() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(2);
//        t1.left = t2;
        t2.left = t3;
        t3.right = t4;
        System.out.println(hasPathSum(t1, 5));
    }


}
