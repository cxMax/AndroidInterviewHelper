package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-16.
 */

public class BBSTree<T extends Comparable<T>> {

    private BBSTreeNode root;

    public static class BBSTreeNode<T extends Comparable<T>> {
        T key;				// 关键字(键值)
        int height;     	// 高度
        BBSTreeNode<T> left;	// 左孩子
        BBSTreeNode<T> right;	// 右孩子

        public BBSTreeNode(T key, BBSTreeNode<T> left, BBSTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    // 构造函数
    public BBSTree() {
        root = null;
    }

    /*
     * 获取树的高度
     */
    private int height(BBSTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(root);
    }

    /*
     * 比较两个值的大小
     */
    private int max(int a, int b) {
        return a>b ? a : b;
    }

    /*
     * 前序遍历"AVL树"
     */
    private void preOrder(BBSTreeNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历"AVL树"
     */
    private void inOrder(BBSTreeNode<T> tree) {
        if(tree != null)
        {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /*
     * 后序遍历"AVL树"
     */
    private void postOrder(BBSTreeNode<T> tree) {
        if(tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /*
     * (递归实现)查找"AVL树x"中键值为key的节点
     */
    private BBSTreeNode<T> search(BBSTreeNode<T> x, T key) {
        if (x==null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BBSTreeNode<T> search(T key) {
        return search(root, key);
    }

    /*
     * (非递归实现)查找"AVL树x"中键值为key的节点
     */
    private BBSTreeNode<T> iterativeSearch(BBSTreeNode<T> x, T key) {
        while (x!=null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public BBSTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(root, key);
    }

    /* 
     * 查找最小结点：返回tree为根结点的AVL树的最小结点。
     */
    private BBSTreeNode<T> minimum(BBSTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BBSTreeNode<T> p = minimum(root);
        if (p != null)
            return p.key;

        return null;
    }

    /* 
     * 查找最大结点：返回tree为根结点的AVL树的最大结点。
     */
    private BBSTreeNode<T> maximum(BBSTreeNode<T> tree) {
        if (tree == null)
            return null;

        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        BBSTreeNode<T> p = maximum(root);
        if (p != null)
            return p.key;

        return null;
    }

    /*
	 * LL：左左对应的情况(左单旋转)。
	 *
	 * 返回值：旋转后的根节点
	 */
    private BBSTreeNode<T> leftLeftRotation(BBSTreeNode<T> k2) {
        BBSTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max( height(k2.left), height(k2.right)) + 1;
        k1.height = max( height(k1.left), k2.height) + 1;

        return k1;
    }

    /*
     * RR：右右对应的情况(右单旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private BBSTreeNode<T> rightRightRotation(BBSTreeNode<T> k1) {
        BBSTreeNode<T> k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max( height(k1.left), height(k1.right)) + 1;
        k2.height = max( height(k2.right), k1.height) + 1;

        return k2;
    }

    /*
	 * LR：左右对应的情况(左双旋转)。
	 *
	 * 返回值：旋转后的根节点
	 */
    private BBSTreeNode<T> leftRightRotation(BBSTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }


    /*
     * RL：右左对应的情况(右双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private BBSTreeNode<T> rightLeftRotation(BBSTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }

    /* 
	 * 将结点插入到AVL树中，并返回根节点
	 *
	 * 参数说明：
	 *     tree AVL树的根结点
	 *     key 插入的结点的键值
	 * 返回值：
	 *     根节点
	 */
    private BBSTreeNode<T> insert(BBSTreeNode<T> tree, T key) {
        if (tree == null) {
            // 新建节点
            tree = new BBSTreeNode<T>(key, null, null);
            if (tree==null) {
                System.out.println("ERROR: create BBSTree node failed!");
                return null;
            }
        } else {
            int cmp = key.compareTo(tree.key);

            if (cmp < 0) {	// 应该将key插入到"tree的左子树"的情况
                tree.left = insert(tree.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0)
                        tree = leftLeftRotation(tree);
                    else
                        tree = leftRightRotation(tree);
                }
            } else if (cmp > 0) {	// 应该将key插入到"tree的右子树"的情况
                tree.right = insert(tree.right, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0)
                        tree = rightRightRotation(tree);
                    else
                        tree = rightLeftRotation(tree);
                }
            } else {	// cmp==0
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }

        tree.height = max( height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void insert(T key) {
        root = insert(root, key);
    }

    /* 
     * 删除结点(z)，返回根节点
     *
     * 参数说明：
     *     tree AVL树的根结点
     *     z 待删除的结点
     * 返回值：
     *     根节点
     */
    private BBSTreeNode<T> remove(BBSTreeNode<T> tree, BBSTreeNode<T> z) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree==null || z==null)
            return null;

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {		// 待删除的节点在"tree的左子树"中
            tree.left = remove(tree.left, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                BBSTreeNode<T> r =  tree.right;
                if (height(r.left) > height(r.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = rightRightRotation(tree);
            }
        } else if (cmp > 0) {	// 待删除的节点在"tree的右子树"中
            tree.right = remove(tree.right, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                BBSTreeNode<T> l =  tree.left;
                if (height(l.right) > height(l.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        } else {	// tree是对应要删除的节点。
            // tree的左右孩子都非空
            if ((tree.left!=null) && (tree.right!=null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    BBSTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    BBSTreeNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                BBSTreeNode<T> tmp = tree;
                tree = (tree.left!=null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        return tree;
    }

    public void remove(T key) {
        BBSTreeNode<T> z;

        if ((z = search(root, key)) != null)
            root = remove(root, z);
    }

    /* 
     * 销毁AVL树
     */
    private void destroy(BBSTreeNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void destroy() {
        destroy(root);
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值 
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BBSTreeNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)	// tree是根节点
                System.out.printf("%2d is root\n", tree.key, key);
            else				// tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (root != null)
            print(root, (T) root.key, 0);
    }

    public static class BBSTreeTest {
        private static int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

        public static void main(String[] args) {
            int i;
            BBSTree<Integer> tree = new BBSTree<Integer>();

            System.out.printf("== 依次添加: ");
            for(i=0; i<arr.length; i++) {
                System.out.printf("%d ", arr[i]);
                tree.insert(arr[i]);
            }

            System.out.printf("\n== 前序遍历: ");
            tree.preOrder();

            System.out.printf("\n== 中序遍历: ");
            tree.inOrder();

            System.out.printf("\n== 后序遍历: ");
            tree.postOrder();
            System.out.printf("\n");

            System.out.printf("== 高度: %d\n", tree.height());
            System.out.printf("== 最小值: %d\n", tree.minimum());
            System.out.printf("== 最大值: %d\n", tree.maximum());
            System.out.printf("== 树的详细信息: \n");
            tree.print();

            i = 8;
            System.out.printf("\n== 删除根节点: %d", i);
            tree.remove(i);

            System.out.printf("\n== 高度: %d", tree.height());
            System.out.printf("\n== 中序遍历: ");
            tree.inOrder();
            System.out.printf("\n== 树的详细信息: \n");
            tree.print();

            // 销毁二叉树
            tree.destroy();
        }
    }

}
