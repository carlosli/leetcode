package com.carlosli.leetcode.basic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    /**
     * ........4
     * ...2           6
     * 1    3        5   7
     *
     * @return
     */
    public static TreeNode makeABalanceTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode4.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode4.right = treeNode6;
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;

        return treeNode4;
    }

    /**
     * .......4
     * ....2           5
     * ..1    3
     * 0
     *
     * @return
     */
    public static TreeNode makeAUnBalanceTree() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode4.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode1.left = treeNode0;

        treeNode4.right = treeNode5;

        return treeNode4;
    }
}