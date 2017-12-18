package com.meizu.thirdparty;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的节点 层级遍历 : 由底部 到 顶部顺序
 * Created by caixi on 17-12-18.
 */

public class BinaryTreeLevelTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        BFSMaker(wrapList, root, 0);
        return wrapList;
    }


    public void BFSMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        BFSMaker(list, root.left, level + 1);
        BFSMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

}
