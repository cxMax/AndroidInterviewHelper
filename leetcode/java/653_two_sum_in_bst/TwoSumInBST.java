package com.meizu.thirdparty;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 18-1-4.
 */

public class TwoSumInBST {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int low = 0;
        int high = nums.size() - 1;
        while (low < high) {
            int total = nums.get(low) + nums.get(high);
            if (total == k) {
                return true;
            } else if (total > k) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
