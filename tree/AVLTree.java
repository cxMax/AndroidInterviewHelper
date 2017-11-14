package com.meizu.thirdparty;

/**
 * @describe : reference : http://www.cnblogs.com/skywang12345/p/3577479.html
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-14.
 */

public class AVLTree {

    private AVLTreeNode root;

    static class AVLTreeNode {

        int val;
        int height;
        AVLTreeNode right;
        AVLTreeNode left;

        public AVLTreeNode(int val, AVLTreeNode right, AVLTreeNode left) {
            this.val = val;
            this.height = 0;
            this.right = right;
            this.left = left;
        }
    }

    public AVLTree() {
        root = null;
    }

    /*
     * 获取树的高度
     */
    private int height(AVLTreeNode tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    /*
     * 前序遍历
     */
    private void preOrder(AVLTreeNode tree) {
        if (tree != null) {
            System.out.print(tree.val);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历
     */
    private void inOrder(AVLTreeNode tree) {
        if (tree != null) {
            preOrder(tree.left);
            System.out.print(tree.val);
            preOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /*
     * 后序遍历
     */
    private void postOrder(AVLTreeNode tree) {
        if (tree != null) {
            preOrder(tree.left);
            preOrder(tree.right);
            System.out.print(tree.val);
        }
    }

    public void postOrder() {
        postOrder(root);
    }


    /*
     * (递归实现)查找"AVL树x"中键值为key的节点
     */
    private AVLTreeNode search(AVLTreeNode tree, int val) {
        if (tree == null) {
            return tree;
        }

        if (tree.val > val) {
            return search(tree.left, val);
        } else if (tree.val < val) {
            return search(tree.right, val);
        } else {
            return tree;
        }
    }

    public AVLTreeNode search(int val) {
        return search(root, val);
    }

    /*
     * (非递归实现)查找"AVL树x"中键值为key的节点
     */
    private AVLTreeNode iterativeSearch(AVLTreeNode tree, int val) {
        while (tree != null) {
            if (tree.val > val) {
                tree = tree.left;
            } else if (tree.val < val) {
                tree = tree.right;
            } else {
                return tree;
            }
        }
        return tree;
    }

    public AVLTreeNode iterativeSearch(int val) {
        return iterativeSearch(root, val);
    }

    /*
     * 查找最小结点：返回tree为根结点的AVL树的最小结点
     */
    private AVLTreeNode minimum(AVLTreeNode tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /*
     * 查找最大结点：返回tree为根结点的AVL树的最大结点
     */
    private AVLTreeNode maximum(AVLTreeNode tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /**
     * 左旋 : LL失去平衡的情况，可以通过一次旋转让AVL树恢复平衡
     *
     * @param k2 旋转前的根节点
     * @return 旋转后的根节点
     */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {
        AVLTreeNode k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * 右旋 : RR失去平衡的情况，可以通过一次旋转让AVL树恢复平衡
     *
     * @param k1
     * @return 旋转后的根节点
     */
    private AVLTreeNode rightRightRotation(AVLTreeNode k1) {
        AVLTreeNode k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }

    /**
     * 左右旋 : 先左节点右旋, 再根节点左旋
     * @param k3 旋转前的根节点
     * @return 旋转后的根节点
     */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    /**
     * 右左旋 : 先右节点左旋, 再根节点右旋
     * @param k1
     * @return
     */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    /**
     * 将结点插入到AVL树中，并返回根节点
     *
     * @param tree 某一节点
     * @param val
     * @return 根节点
     */
    private AVLTreeNode insert(AVLTreeNode tree, int val) {
        if (tree == null) {
            tree = new AVLTreeNode(val, null, null);
        } else {
            if (val < tree.val){
                tree.left = insert(tree.left, val);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (val < tree.left.val) {
                        tree = leftLeftRotation(tree);
                    } else {
                        tree = leftRightRotation(tree);
                    }
                }
            } else if (val > tree.val) {
                tree.right = insert(tree.right, val);
                if (height(tree.right) - height(tree.left) == 2) {
                    if (val > tree.right.val) {
                        tree = rightRightRotation(tree);
                    } else {
                        tree = rightLeftRotation(tree);
                    }
                }
            } else {
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    /**
     * 删除节点z, 返回根节点
     * @param tree
     * @param z
     * @return 根节点
     */
    private AVLTreeNode remove(AVLTreeNode tree, AVLTreeNode z) {
        if (tree == null || z == null) {
            return null;
        }

        if (z.val < tree.val) {
            tree.left = remove(tree.left, z);
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode r =  tree.right;
                if (height(r.left) > height(r.right)) {
                    tree = rightLeftRotation(tree);
                } else {
                    tree = rightRightRotation(tree);
                }
            }
        } else if (z.val > tree.val) {
            tree.right = remove(tree.right, z);
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode l = tree.left;
                if (height(l.right) > height(l.left)) {
                    tree = leftRightRotation(tree);
                } else {
                    tree = leftLeftRotation(tree);
                }
            }
        } else {
            if ((tree.left!=null) && (tree.right!=null)) {
                if (height(tree.left) > height(tree.right)) {
                    AVLTreeNode max = maximum(tree.left);
                    tree.val = max.val;
                    tree.left = remove(tree.left, max);
                } else {
                    AVLTreeNode min = maximum(tree.right);
                    tree.val = min.val;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLTreeNode tmp = tree;
                tree = (tree.left!=null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        return tree;
    }

    public void remove(int val) {
        AVLTreeNode z;
        if ((z = search(root, val)) != null){
            root = remove(root, z);
        }
    }

    private void destroy(AVLTreeNode tree) {
        if (tree == null) {
            return ;
        }
        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }
        tree = null;
    }

    private void destroy() {
        destroy(root);
    }
}
