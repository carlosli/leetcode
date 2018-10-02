package com.carlosli.leetcode.tree;

import com.carlosli.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.makeABalanceTree();

        BinaryTreePreorderTraversal144 binaryTreePreorderTraversal144 = new BinaryTreePreorderTraversal144();

        List<Integer> integers = binaryTreePreorderTraversal144.preorderTraversal(treeNode);
        System.out.println(Arrays.toString(integers.toArray()));

        System.out.println("\n----------------");

        List<Integer> integers2 = binaryTreePreorderTraversal144.preorderTraversal1(treeNode);
        System.out.println(Arrays.toString(integers2.toArray()));
        System.out.println("\n----------------");

        List<Integer> integers3 = binaryTreePreorderTraversal144.preorderTraversal2(treeNode);
        System.out.println(Arrays.toString(integers3.toArray()));

    }

    /**
     * 循环
     * 用栈模拟了递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();

        recursion(root, preorder);
        return preorder;
    }

    public void recursion(TreeNode node, List<Integer> preorder) {

        preorder.add(node.val);

        if (node.left != null) {
            recursion(node.left, preorder);
        }

        if (node.right != null) {
            recursion(node.right, preorder);
        }

    }

    /**
     * 分治法的思想，每次将左子树或者右子树的内容加入就好
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(root.val);
        if (root.left!=null) arrayList.addAll(preorderTraversal2(root.left));
        if (root.right!=null) arrayList.addAll(preorderTraversal2(root.right));

        return arrayList;
    }
}
