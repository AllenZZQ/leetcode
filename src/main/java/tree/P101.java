package tree;

import junit.framework.TestCase;

import java.util.LinkedList;

public class P101 extends TestCase {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root.left);
        linkedList.add(root.right);
        // 层序遍历
        while (!linkedList.isEmpty()) {
            TreeNode t1 = linkedList.poll();
            TreeNode t2 = linkedList.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            linkedList.add(t1.left);
            linkedList.add(t2.right);
            linkedList.add(t1.right);
            linkedList.add(t2.left);
        }
        return true;
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }



    public void test() {

    }


}
