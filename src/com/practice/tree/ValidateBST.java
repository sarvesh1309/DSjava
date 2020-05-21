package com.practice.tree;

import java.util.Stack;

public class ValidateBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int isValidBST(TreeNode A) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = A;
		int prev = -1;
		while (true) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			if (st.isEmpty())
				break;
			curr = st.pop();
			// System.out.print(curr.val);
			if (prev > curr.val)
				return 0;
			prev = curr.val;
			curr = curr.right;
		}
		return 1;

	}

}
