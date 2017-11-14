package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-14.
 */

public class RBTree {

    private RBTNode root;

    private static final boolean RED = Boolean.FALSE;
    private static final boolean BLACK = Boolean.TRUE;

    static class RBTNode {

        boolean color;
        int val;
        RBTNode left;
        RBTNode right;
        RBTNode parent;

        public RBTNode(int val, boolean color, RBTNode parent, RBTNode left, RBTNode right) {
            this.val = val;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return val;
        }
    }

    /**
     * 查找最小结点：返回tree为根结点的红黑树的最小结点
     *
     * @param tree
     * @return
     */
    private RBTNode minimum(RBTNode tree) {
        if (tree == null) {
            return null;
        }

        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /**
     * 查找最大结点：返回tree为根结点的红黑树的最大结点
     *
     * @param tree
     * @return
     */
    private RBTNode maximum(RBTNode tree) {
        if (tree == null) {
            return null;
        }

        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /**
     * 找结点(x)的后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"。
     *
     * @param x
     * @return
     */
    public RBTNode successor(RBTNode x) {
        if (x.right != null) {
            return minimum(x.right);
        }

        RBTNode y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    public RBTNode predecessor(RBTNode x) {
        if (x.left != null) {
            return maximum(x.left);
        }

        RBTNode y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /*
    * 对红黑树的节点(x)进行左旋转
    *
    * 左旋示意图(对节点x进行左旋)：
    *      px                             px
    *     /                              /
    *    x                              y
    *   /  \      --(左旋)-.           / \                #
    *  lx   y                          x  ry
    *     /   \                       /  \
    *    ly   ry                     lx  ly
    *
    *
    */
    private void leftRotate(RBTNode x) {
        RBTNode y = x.right;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBTNode y) {
        RBTNode x = y.parent;

        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        // 将 “y的父亲” 设为 “x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.root = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”

            } else {
                y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
            }
        }

        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }

    /**
     * insert 和 remove 暂时都没看懂
     * reference : http://www.cnblogs.com/skywang12345/p/3624343.html
     */

}
