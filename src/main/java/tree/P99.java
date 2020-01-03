package tree;

import junit.framework.TestCase;

/**
 * 中序遍历，解题的关键
 */
public class P99 extends TestCase {

    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;


    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * inOrder
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            if (prev != null) {
                if (prev.val >= root.val && first == null) {
                    first = prev;
                }
                if (prev.val >= root.val) {
                    second = root;
                }
            }
            prev = root;
            traverse(root.right);
        }
    }

    public void test() {
        TreeNode l = new TreeNode(Integer.MIN_VALUE);
        TreeNode root = new TreeNode(2);
        TreeNode r = new TreeNode(1);
        root.left = l;
        root.right = r;
        recoverTree(root);
        System.out.println(1);
    }
}
