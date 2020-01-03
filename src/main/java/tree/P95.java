package tree;

import java.util.ArrayList;
import java.util.List;

public class P95 {

    // 递归

    /**
     * 求解1-n的所有可能，只要从1-n遍历，每次以i为root，左边获取1-i-1的所有可能，右边获取i+1-n的所有可能，然后就能获取在i处的所有可能
     * 类似斐波那契数列的递归，时间复杂度高
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
          return new ArrayList<>();
        }
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int i = start; i <= end; i ++) {
            List<TreeNode> left = genTrees(start, i - 1);
            List<TreeNode> right = genTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }


    // dp
    /**
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<>();
        result[0].add(null);
        for (int len = 1; len <= n; len ++) {
            result[len] = new ArrayList<>();

            for (int j = 0; j < len; j ++) { // root节点从1到len
                for (TreeNode nodeL : result[j]) { // 左节点最大值为j
                    for (TreeNode nodeR : result[len - j - 1]) { // 右节点全部offset + j + 1
                        TreeNode root = new TreeNode(j + 1);
                        root.left = nodeL;
                        root.right = clone(nodeR, j + 1);
                        result[len].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }


}
