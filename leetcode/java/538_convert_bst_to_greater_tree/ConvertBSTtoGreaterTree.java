package com.meizu.thirdparty;

/**
 * 每个结点值加上所有比它大的结点值总和当作新的结点值
 * Created by caixi on 17-12-19.
 */

public class ConvertBSTtoGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }

}
