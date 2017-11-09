package com.meizu.thirdparty;

/**
 * @describe : reference : http://www.cnblogs.com/Anker/archive/2013/01/28/2880581.html
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-9.
 */

public class BinaryTreeSearch {

    /*
     * 递归查找某 某数
     */
    public TreeNode recursionSearch(TreeNode treeNode, int val) {
        if (treeNode == null || val == treeNode.val) {
            return treeNode;
        }
        if (val < treeNode.val) {
            return recursionSearch(treeNode.left, val);
        } else {
            return recursionSearch(treeNode.right, val);
        }
    }

    /*
     * 非递归查找 某数
     */
    public TreeNode search(TreeNode treeNode, int val) {
        while (treeNode != null && val != treeNode.val) {
            if (val < treeNode.val) {
                treeNode = treeNode.left;
            } else {
                treeNode = treeNode.right;
            }
        }
        return treeNode;
    }
}
