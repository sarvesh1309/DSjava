package com.practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeView {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	static class PairNode {
		TreeNode node;
		int pos;

		public PairNode(TreeNode n, int pos) {
			this.node = n;
			this.pos = pos;
		}
	}

	/**
	 * 
	 * @param root
	 */
	public static void printTopView(TreeNode root) {
		Queue<PairNode> q = new LinkedList<>();
		q.add(new PairNode(root, 0));
		Map<Integer, Integer> map = new HashMap<>();
		int min = 0;
		int max = 0;
		while (!q.isEmpty()) {
			PairNode tmp = q.poll();
			TreeNode treeTmp = tmp.node;
			int position = tmp.pos;
			if (!map.containsKey(position)) {
				map.put(position, treeTmp.val);
			}
			min = Math.min(min, position);
			max = Math.max(max, position);
			if (treeTmp.left != null)
				q.add(new PairNode(treeTmp.left, position - 1));
			if (treeTmp.right != null)
				q.add(new PairNode(treeTmp.right, position + 1));

		}
		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i) + " ");
		}
	}

	/**
	 * 
	 * @param root
	 */
	public static void printLowerView(TreeNode root) {
		Queue<PairNode> q = new LinkedList<>();
		q.add(new PairNode(root, 0));
		Map<Integer, Integer> map = new HashMap<>();
		int min = 0;
		int max = 0;
		while (!q.isEmpty()) {
			PairNode tmp = q.poll();
			TreeNode treeTmp = tmp.node;
			int position = tmp.pos;
			map.put(position, treeTmp.val);
			min = Math.min(min, position);
			max = Math.max(max, position);
			if (treeTmp.left != null)
				q.add(new PairNode(treeTmp.left, position - 1));
			if (treeTmp.right != null)
				q.add(new PairNode(treeTmp.right, position + 1));

		}

		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i) + " ");
		}
	}

	/**
	 * 
	 * @param root
	 */
	public static void printLeftViewOfTree(TreeNode root) {
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		while (!qu.isEmpty()) {
			int firstElem = qu.peek().val;
			int size = qu.size();

			for (int i = 0; i < size; i++) {
				TreeNode tmp = qu.poll();

				if (tmp.left != null) {
					qu.add(tmp.left);
				}
				if (tmp.right != null)
					qu.add(tmp.right);
			}
			System.out.print(firstElem + " ");
		}
	}

	/**
	 * 
	 * @param root
	 */
	public static void printRightViewOfTree(TreeNode root) {
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			int lastElem = 0;
			for (int i = 0; i < size; i++) {
				TreeNode tmp = qu.poll();
				lastElem = tmp.val;
				if (tmp.left != null) {
					qu.add(tmp.left);
				}
				if (tmp.right != null)
					qu.add(tmp.right);
			}
			System.out.print(lastElem + " ");
		}
	}

}
