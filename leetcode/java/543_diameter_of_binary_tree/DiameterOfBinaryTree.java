package com.cxmax.popup.library;

/**
 * @describe : 求二叉树的直径, 也就是最深左节点 + 最深右节点 之和 再+1
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/21.
 */

public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    int max = 0;
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

}
