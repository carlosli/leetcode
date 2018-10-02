package com.carlosli.leetcode.tree;

import com.carlosli.leetcode.basic.TreeNode;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {

        BalancedBinaryTree110 balancedBinaryTree110 = new BalancedBinaryTree110();
        TreeNode treeNode = TreeNode.makeABalanceTree();
        boolean balanced = balancedBinaryTree110.isBalanced(treeNode);
        System.out.println(balanced);

        System.out.println("\n----------------");

        TreeNode unBalanceTree = TreeNode.makeAUnBalanceTree();
        boolean balanced1 = balancedBinaryTree110.isBalanced(unBalanceTree);
        System.out.println(balanced1);


    }

    public boolean isBalanced(TreeNode root) {
        int left = childrenDepth(root.left);
        int right = childrenDepth(root.right);

        if (Math.abs(Math.subtractExact(left, right)) < 2) {
            return true;
        } else {
            return false;
        }
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

    public int childrenHeightBalanced(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = childrenHeightBalanced(root.left);
        int right = childrenHeightBalanced(root.right);

        return Math.subtractExact(left, right);

    }


}
