package com.practice.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BinaryPrintPaths {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void printPathIter(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> st = new Stack<>();
		Stack<String> stPath = new Stack<>();
		List<String> paths = new ArrayList<>();
		st.push(root);
		stPath.push(String.valueOf(root.val));

		while (!st.isEmpty()) {
			TreeNode tmp = st.pop();
			String str = stPath.pop();

			if (tmp.left == null && tmp.right == null) {
				paths.add(str);
			} else {
				if (tmp.left != null) {
					st.push(tmp.left);
					stPath.push(str + "-" + tmp.left.val);
				}
				if (tmp.right != null) {
					st.push(tmp.right);
					stPath.push(str + "-" + tmp.right.val);
				}
			}
		}
		System.out.println(paths);

	}

	public static void printPath(TreeNode root, Deque<Integer> path) {
		if (root == null)
			return;
		path.add(root.val);
		if (root.left == null && root.right == null) {
			System.out.println(path);
		}
		printPath(root.left, path);
		printPath(root.right, path);
		path.removeLast();
	}

}
