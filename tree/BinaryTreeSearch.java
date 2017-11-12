package com.meizu.thirdparty;

import android.support.annotation.NonNull;

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

    /*
     * 查找最小值
     */
    public TreeNode findMin(TreeNode treeNode) {
        if (treeNode == null) {
            return treeNode;
        }

        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    /*
     * 查找最大值
     */
    public TreeNode findMax(TreeNode treeNode) {
        if (treeNode == null) {
            return treeNode;
        }

        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }

    /*
     * 前驱 :
     * 含义理解 : http://javayhu.me/blog/2014/05/09/python-data-structures---c4-trees/
     * 算法 : http://blog.csdn.net/cwqbuptcwqbupt/article/details/7468676
     */
    public TreeNode predecessor(TreeNode treeNode) {
        if (treeNode.left != null) {
            return findMax(treeNode.left);
        }

        TreeNode y = treeNode.parent;
        while(y != null && treeNode == y.left) {
            treeNode = y;
            y = y.parent;
        }
        return y;
    }

    /*
     * 后继 :
     * 含义理解 : http://javayhu.me/blog/2014/05/09/python-data-structures---c4-trees/
     * 算法 : http://blog.csdn.net/cwqbuptcwqbupt/article/details/7468676
     */
    public TreeNode successor(TreeNode treeNode) {
        if (treeNode.right != null) {
            return findMin(treeNode.right);
        }

        TreeNode y = treeNode.parent;
        while (y != null && treeNode == y.right) {
            treeNode = y;
            y = y.parent;
        }
        return y;
    }

    /*
     * 向一棵二叉树插入指定的数字
     * reference : http://blog.csdn.net/sinat_26935081/article/details/44787515
     */
    public void insert(Tree tree, int val) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = val;

        //如果二叉树为空，直接将要插入的值作为根
        if (tree.root == null) {
            tree.root = treeNode;
        } else {
            // 树的根节点
            TreeNode q = tree.root;
            while (true) {
                if (val < q.val) {
                    // 如果左节点为null , 直接指向左节点 , 否则递归至最左节点
                    if (q.left == null) {
                        q.left = treeNode;
                        treeNode.parent = q;
                        break;
                    } else {
                        q = q.left;
                    }
                } else if (val > q.val) {
                    // 同理
                    if (q.right == null) {
                        q.right = treeNode;
                        treeNode.parent = q;
                        break;
                    } else {
                        q = q.right;
                    }
                } else {
                    // 已存在
                    break;
                }
            }
        }
    }

    /*
     * 删除 :
     *
     * reference : https://leetcode.com/problems/delete-node-in-a-bst/discuss/
     */
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right , key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, root.val);
        }
        return root;
    }
}
