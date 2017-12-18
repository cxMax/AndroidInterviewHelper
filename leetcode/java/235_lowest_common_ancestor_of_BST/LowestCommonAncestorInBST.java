package com.meizu.thirdparty;

/**
 * 一个搜索二叉树, 给两个子节点 和 根节点 , 找出这两个节点的最小公共祖先
 * Created by caixi on 17-12-18.
 */

public class LowestCommonAncestorInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
