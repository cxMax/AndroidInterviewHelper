package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-12-13.
 */

public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val == right.val) {
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
        }
        return false;
    }

}
