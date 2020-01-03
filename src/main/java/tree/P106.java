package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 已知后序、中序，求树，无重复
 */
public class P106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, map);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] postOrder, Map<Integer, Integer> map) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int index = map.get(root.val);
        root.right = helper(postEnd - 1, index + 1, inEnd, postOrder, map);
        root.left = helper(postEnd - (inEnd - index + 1), inStart, index - 1, postOrder, map);
        return root;
    }
}
