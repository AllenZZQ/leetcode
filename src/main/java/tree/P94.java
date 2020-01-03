package tree;

import java.util.ArrayList;
import java.util.List;

public class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(result, root);
        return result;
    }

    private void traversal(List<Integer> result, TreeNode node) {
        if (node != null) {
            traversal(result, node.left);
            result.add(node.val);
            traversal(result, node.right);
        }
    }
}
