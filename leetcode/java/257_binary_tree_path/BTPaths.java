package com.cxmax.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/9.
 */

public class BTPaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", result);
        }
        return result;
    }

    private void searchBT(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", result);
        }
    }
}
