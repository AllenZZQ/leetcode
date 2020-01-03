package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @see P112
 */
public class P113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        helper(root, sum, list);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list)); // 在这边复制arraylist比在下面好，省空间、省时间
        } else {
            if (root.left != null) {
                helper(root.left, sum - root.val, list);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                helper(root.right, sum - root.val, list);
                list.remove(list.size() - 1);
            }
        }
    }




}
