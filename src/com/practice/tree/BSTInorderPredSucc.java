package com.practice.tree;

public class BSTInorderPredSucc {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// time complexity = O(h) logn for complete binary tree otherwise n for skew
	// tree
	// Space complexity = O(1)
	public static int inorderPredeccesor(TreeNode root, int key) {
		TreeNode pred = null;
		while (root != null) {
			if (key > root.val) {
				pred = root;
				root = root.right;
			} else if (key < root.val) {
				root = root.left;
			} else {
				// key found
				if (root.left != null) {
					pred = root.left;
					while (pred.right != null) {
						pred = pred.right;
					}
				}
				break;
			}
		}

		if (pred == null)
			return -1;
		return pred.val;

	}

	// time complexity = O(h) logn for complete binary tree otherwise n for skew
	// tree
	// Space complexity = O(1)
	public static int inorderSuccesor(TreeNode root, int key) {
		TreeNode succ = null;
		while (root != null) {
			if (key > root.val) {
				root = root.right;
			} else if (key < root.val) {
				succ = root;
				root = root.left;
			} else {
				// key found
				if (root.right != null) {
					succ = root.right;
					while (succ.left != null) {
						succ = succ.left;
					}
				}
				break;
			}
		}

		if (succ == null)
			return -1;
		return succ.val;

	}

}
