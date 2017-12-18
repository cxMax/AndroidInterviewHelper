package com.meizu.thirdparty;

/**
 * 给一个二叉树, 给一个数字, 判断该二叉树是否有路径满足节点之和等于这个数字
 * Created by caixi on 17-12-18.
 */

public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
