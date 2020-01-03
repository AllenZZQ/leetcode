package tree;

import junit.framework.TestCase;

public class P104 extends TestCase {



    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void test() {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);
        node3.right = node2;
        node1.right = node3;
        node.right = node1;
        System.out.println(maxDepth(node));
        System.out.println("");
    }

}
