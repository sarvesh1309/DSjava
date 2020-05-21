package com.practice.tree;

import java.util.List;

public class CheckIfBST {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	

	/**
	 * O(n^2)
	 * 
	 * @param root
	 * @return
	 */
	int isBST(Node root) {
		if (root == null) {
			return 1;
		} else {
			boolean isBST = true;
			if (root.left != null && root.data < max(root.left)) {
				isBST = false;
			}
			if (isBST && (root.right != null && root.data > min(root.right))) {
				isBST = false;
			}
			if (!isBST) {
				return 0;
			} else {
				if (isBST(root.left) == 1 && isBST(root.right) == 1) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	private int max(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		} else {
			int value = Math.max(root.data, Math.max(max(root.left), max(root.right)));
			return value;
		}
	}

	private int min(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		} else {
			int value = Math.min(root.data, Math.min(min(root.left), min(root.right)));
			return value;
		}
	}

}
