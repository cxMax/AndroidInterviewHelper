/**
 * @describe : 给定一个范围, 修剪二叉树, 使其中的元素位于这两个范围之间
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/12/21.
 */

public class TrimBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) {
            return trimBST(root.right, L ,R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
