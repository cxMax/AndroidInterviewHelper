package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-16.
 */

public class LeftistHeap<T extends Comparable<T>> {

    private LeftistNode<T> root;    // 根结点

    private class LeftistNode<T extends Comparable<T>> {
        T key;                    // 关键字(键值)
        int npl;                // 零路经长度(Null Path Length)
        LeftistNode<T> left;    // 左孩子
        LeftistNode<T> right;    // 右孩子

        public LeftistNode(T key, LeftistNode<T> left, LeftistNode<T> right) {
            this.key = key;
            this.npl = 0;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "key:" + key;
        }
    }

    public LeftistHeap() {
        root = null;
    }

    /*
     * 前序遍历"左倾堆"
     */
    private void preOrder(LeftistNode<T> heap) {
        if (heap != null) {
            System.out.print(heap.key + " ");
            preOrder(heap.left);
            preOrder(heap.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历"左倾堆"
     */
    private void inOrder(LeftistNode<T> heap) {
        if (heap != null) {
            inOrder(heap.left);
            System.out.print(heap.key + " ");
            inOrder(heap.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /*
     * 后序遍历"左倾堆"
     */
    private void postOrder(LeftistNode<T> heap) {
        if (heap != null) {
            postOrder(heap.left);
            postOrder(heap.right);
            System.out.print(heap.key + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /*
     * 合并"左倾堆x"和"左倾堆y"
     */
    private LeftistNode<T> merge(LeftistNode<T> x, LeftistNode<T> y) {
        if (x == null) return y;
        if (y == null) return x;

        // 合并x和y时，将x作为合并后的树的根；
        // 这里的操作是保证: x的key < y的key
        if (x.key.compareTo(y.key) > 0) {
            LeftistNode<T> tmp = x;
            x = y;
            y = tmp;
        }

        // 将x的右孩子和y合并，"合并后的树的根"是x的右孩子。
        x.right = merge(x.right, y);

        // 如果"x的左孩子为空" 或者 "x的左孩子的npl<右孩子的npl"
        // 则，交换x和y
        if (x.left == null || x.left.npl < x.right.npl) {
            LeftistNode<T> tmp = x.left;
            x.left = x.right;
            x.right = tmp;
        }
        if (x.right == null || x.left == null)
            x.npl = 0;
        else
            x.npl = (x.left.npl > x.right.npl) ? (x.right.npl + 1) : (x.left.npl + 1);

        return x;
    }

    public void merge(LeftistHeap<T> other) {
        this.root = merge(this.root, other.root);
    }

    /*
     * 新建结点(key)，并将其插入到左倾堆中
     *
     * 参数说明：
     *     key 插入结点的键值
     */
    public void insert(T key) {
        LeftistNode<T> node = new LeftistNode<T>(key, null, null);

        // 如果新建结点失败，则返回。
        if (node != null)
            this.root = merge(this.root, node);
    }

    /*
     * 删除根结点
     *
     * 返回值：
     *     返回被删除的节点的键值
     */
    public T remove() {
        if (this.root == null)
            return null;

        T key = this.root.key;
        LeftistNode<T> l = this.root.left;
        LeftistNode<T> r = this.root.right;

        this.root = null;          // 删除根节点
        this.root = merge(l, r);   // 合并左右子树

        return key;
    }

    /*
     * 销毁左倾堆
     */
    private void destroy(LeftistNode<T> heap) {
        if (heap == null)
            return;

        if (heap.left != null)
            destroy(heap.left);
        if (heap.right != null)
            destroy(heap.right);

        heap = null;
    }

    public void clear() {
        destroy(root);
        root = null;
    }

    /*
     * 打印"左倾堆"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(LeftistNode<T> heap, T key, int direction) {

        if (heap != null) {

            if (direction == 0)    // heap是根节点
                System.out.printf("%2d(%d) is root\n", heap.key, heap.npl);
            else                // heap是分支节点
                System.out.printf("%2d(%d) is %2d's %6s child\n", heap.key, heap.npl, key, direction == 1 ? "right" : "left");

            print(heap.left, heap.key, -1);
            print(heap.right, heap.key, 1);
        }
    }

    public void print() {
        if (root != null)
            print(root, root.key, 0);
    }

    public static class LeftistHeapTest {

        public static void main(String[] args) {
            int a[] = {10, 40, 24, 30, 36, 20, 12, 16};
            int b[] = {17, 13, 11, 15, 19, 21, 23};
            LeftistHeap<Integer> ha = new LeftistHeap<Integer>();
            LeftistHeap<Integer> hb = new LeftistHeap<Integer>();

            System.out.printf("== 左倾堆(ha)中依次添加: ");
            for (int i = 0; i < a.length; i++) {
                System.out.printf("%d ", a[i]);
                ha.insert(a[i]);
            }
            System.out.printf("\n== 左倾堆(ha)的详细信息: \n");
            ha.print();


            System.out.printf("\n== 左倾堆(hb)中依次添加: ");
            for (int i = 0; i < b.length; i++) {
                System.out.printf("%d ", b[i]);
                hb.insert(b[i]);
            }
            System.out.printf("\n== 左倾堆(hb)的详细信息: \n");
            hb.print();

            // 将"左倾堆hb"合并到"左倾堆ha"中。
            ha.merge(hb);
            System.out.printf("\n== 合并ha和hb后的详细信息: \n");
            ha.print();
        }
    }
}
