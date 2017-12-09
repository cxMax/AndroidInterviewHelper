package com.cxmax.test1;

/**
 * @describe : 翻转一个二叉树
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/9.
 */

public class InvertBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先(DFS)递归
     * 递归的表现 : 类似于冒泡算法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;

    }

}
