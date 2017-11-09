package com.meizu.thirdparty;

import java.util.Stack;

/**
 * @describe : reference : http://www.jianshu.com/p/456af5480cee
 * @usage : System.out.print 打印位置, 决定遍历顺序
 * <p>
 * </p>
 * Created by caixi on 17-11-9.
 */

public class BinaryTreeTraversal {

    /*
     * 递归先序遍历 (根左右)
     */
    public void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    /*
     * 非递归先序遍历 (根左右)
     */
    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while(node != null) {
                System.out.print(node.val + " ");
                treeNodeStack.push(node);
                node = node.left;
            }

            // 如果左子树为null了, 回退到节点, 遍历右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    /*
     * 递归中序遍历 (左根右)
     */
    public void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.print(root.val + " ");
            recursionMiddleorderTraversal(root.right);
        }
    }

    /*
     * 非递归中序遍历 (左根右)
     */
    public void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /*
     * 递归后序遍历 (左右根)
     */
    public void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    /*
     * 非递归后序遍历 (左右根)
     */
    public void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            node = treeNodeStack.peek();
            if (node.right == null || node.right == lastNode) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastNode = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }
}