package linkedList;


import java.util.ArrayList;
import java.util.List;

public class P109 {

    /**
     * 常规avl树，旋转
     */
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode treeNode = null;
        while (head != null) {
            treeNode = insert(head.val, treeNode);
            head = head.next;
        }
        return treeNode;
    }

    // 注意ListNode是有序的，递归
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMiddle(head);
        TreeNode node = new TreeNode(mid.val);
        if (mid == head) {
            return node;
        }
        node.left = sortedListToBST2(head);
        node.right = sortedListToBST2(mid.next);
        return node;
    }

    // 思维同法2，空间换时间，避免链表的重复遍历
    public TreeNode sortedListToBST3(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return convertToBST3(values, 0, values.size() - 1);
    }



    private TreeNode convertToBST3(List<Integer> values, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = convertToBST3(values, l, mid - 1);
        node.right = convertToBST3(values, mid + 1, r);
        return node;
    }




    // region method 2
    private ListNode findMiddle(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

    // endregion


    // region method 1
    private boolean flag = false;

    private TreeNode insert(int t, TreeNode node) {
        if (node == null) {
            return new TreeNode(t);
        }
        int c = t - node.val;
        if (c < 0) {
            node.left = insert(t, node.left);
            if (height(node.left) - height(node.right) == 2) {
                if (t - node.left.val < 0) {
                    node = rotateWithLeft(node);
                } else {
                    node = doubleRotateWithLeft(node);
                }
            }
        } else if (c > 0) {
            node.right = insert(t, node.right);
            if (height(node.right) - height(node.left) == 2) {
                if (t - node.right.val > 0) {
                    node = rotateWithRight(node);
                } else {
                    node = doubleRotateWithRight(node);
                }
            }
        }
        updateHeight(node);
        return node;
    }

    private TreeNode doubleRotateWithRight(TreeNode k3) {
        k3.right = rotateWithLeft(k3.right);
        return rotateWithRight(k3);
    }

    private TreeNode rotateWithRight(TreeNode k2) {
        TreeNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        updateHeight(k2);
        updateHeight(k1);
        return k1;
    }

    private TreeNode doubleRotateWithLeft(TreeNode k3) {
        k3.left = rotateWithRight(k3.left);
        return rotateWithLeft(k3);
    }

    private TreeNode rotateWithLeft(TreeNode k2) {
        TreeNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        updateHeight(k2);
        updateHeight(k1);
        return k1;
    }


    private int height(TreeNode node) {
        return node != null ? node.height : -1;
    }

    private void updateHeight(TreeNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
    // endregion

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    int height;

    TreeNode(int x) {
        val = x;
    }
}

