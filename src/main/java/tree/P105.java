package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 已知先序、中序，求树，无重复
 */
public class P105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, map);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder,  Map<Integer, Integer> map) {
        if (preStart >= preOrder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = map.get(root.val);
        root.left = helper(preStart + 1, inStart, index -1, preOrder, map);
        root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preOrder, map);
        return root;
    }
}
