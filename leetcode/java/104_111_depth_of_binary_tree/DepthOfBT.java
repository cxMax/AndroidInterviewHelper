package com.cxmax.test1;

/**
 * @describe : 求二叉树的最长深度
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/9.
 */

public class DepthOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = minDepth(root.left);
        int R = minDepth(root.right);
        return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
    }
}
