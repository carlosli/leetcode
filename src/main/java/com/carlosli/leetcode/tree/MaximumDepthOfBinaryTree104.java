package com.carlosli.leetcode.tree;

import com.carlosli.leetcode.basic.TreeNode;

public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree104 maximumDepthOfBinaryTree104 = new MaximumDepthOfBinaryTree104();
        TreeNode treeNode = TreeNode.makeABalanceTree();
        int i = maximumDepthOfBinaryTree104.childrenDepth(treeNode);
        System.out.println(i);

        System.out.println("\n----------------");

        TreeNode unBalanceTree = TreeNode.makeAUnBalanceTree();
        int i1 = maximumDepthOfBinaryTree104.childrenDepth(unBalanceTree);
        System.out.println(i1);
    }

    /**
     * 分治的思想
     * 当前节点的深等于左子树右子树最大的+1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int i = childrenDepth(root);
        return i;
    }

    public int childrenDepth(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 0;
        if (root.left != null) {
            left = childrenDepth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = childrenDepth(root.right);
        }

        return Math.max(left, right) + 1;

    }
}
