package com.cxmax.test1;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/10.
 */

public class IsSubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.val == t2.val) {
            if (isSameTree(t1, t2)) {
                return true;
            }
        }
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) {
            return true;
        }
        if(t1==null || t2==null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
