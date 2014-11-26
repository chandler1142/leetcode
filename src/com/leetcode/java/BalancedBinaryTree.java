package com.leetcode.java;
/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		return determine(root) >= 0 ? true : false;
	}

	private static int determine(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = determine(root.left);
			int rightDepth = determine(root.right);
			if (leftDepth < 0 || rightDepth < 0
					|| Math.abs(leftDepth - rightDepth) > 1)
				return -1;
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}
	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.right = node3;
		node1.left = node2;
		node2.left = node4;
		node3.right = node6;
		node3.left = node5;
		node5.right = node7;
		
		System.out.println(isBalanced(node1));
		
	}
}