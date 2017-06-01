package com.cxmax.android_clean_architecture.widget;

import java.nio.BufferUnderflowException;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/5/31.
 */

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    public static class BinaryNode<AnyType> {

        public BinaryNode(AnyType element) {
            this(element, null, null);
        }

        public BinaryNode(AnyType element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode left;
        BinaryNode right;
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x , root);
    }

    public void remove(AnyType x) {
        root = remove(x , root);
    }

    private boolean contains(AnyType x , BinaryNode<AnyType> t ) {
        if (t == null) {
            return false;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            return contains(x, t.left);
        } else {
            return compareResult <= 0 || contains(x, t.right);
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) {
            while(t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x , BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<AnyType>(x , null , null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x , t.left);
        } else if (compareResult > 0) {
            t.right = insert(x , t.right);
        }
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x , BinaryNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x , t.left);
        } else if (compareResult > 0) {
            t.right = remove(x , t.right);
        } else if (t.left != null && t.right != null) {
            t.element = (AnyType) findMin(t.right).element;
            t.right = remove(t.element , t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.print("Empty Tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.print(t.element);
            printTree(t.right);
        }
    }

    private int height(BinaryNode<AnyType> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left) , height(t.right));
        }
    }
}
