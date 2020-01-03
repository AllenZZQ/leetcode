package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @see P113
 */
public class P129 {

    List<List<Integer>> result = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int sum = 0;
        for (List<Integer> l : result) {
            sum += getSum(l);
        }
        return sum;
    }

    private int sum = 0;

    public int sumNumbers2(TreeNode root) {
        traversal(root, 0);
        return sum;
    }

    /**
     * 先序遍历
     * @param root
     * @param i
     */
    private void traversal(TreeNode root, int i) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += i * 10 + root.val;
        } else {
            i = i * 10 + root.val;
            traversal(root.left, i);
            traversal(root.right, i);
        }
    }

    private int getSum(List<Integer> list) {

        int sum = list.get(0);
        for (int i = 1; i < list.size(); i ++) {
            sum = sum * 10 + list.get(i);
        }
        return sum;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(list)); // 在这边复制arraylist比在下面好，省空间、省时间
        } else {
            if (root.left != null) {
                helper(root.left, list);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                helper(root.right, list);
                list.remove(list.size() - 1);
            }
        }
    }


}
