package com.meizu.thirdparty;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 17-11-15.
 */

public class HuffmanTest {

    private static final int a[] = {5, 6, 8, 7, 15};

    public static void main(String[] args) {
        int i;
        HuffmanTree tree;

        System.out.print("== 添加数组: ");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        // 创建数组a对应的Huffman树
        tree = new HuffmanTree(a);

        System.out.println("== 树的详细信息: ");
        tree.print();
    }

}
