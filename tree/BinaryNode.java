package com.cxmax.android_clean_architecture.widget;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/5/31.
 */

public class BinaryNode<AnyType> {

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
