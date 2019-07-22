package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Qs 1036
 * 
 * @author sarveshkumar
 *
 */
public class EscapeALargeMaze {

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		if (blocked.length == 0) {
			return true;
		}
		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// convert blocked in set
		Set<String> blocker = new HashSet<>();
		for (int i = 0; i < blocked.length; i++) {
			blocker.add(blocked[i][0] + "_" + blocked[i][1]);
		}
		// queue for BFS
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { source[0], source[1] });
		// visited set
		Set<String> visited = new HashSet<>();

		return isEscapePossibleHelper(blocker, visited, q, target, source[0], source[1], dir);

	}

	private boolean isEscapePossibleHelper(Set<String> blocker, Set<String> visited, Queue<int[]> q, int[] target,
			int row, int col, int[][] dir) {

		visited.add(row + "_" + col);
		int limit = 50;
		while (!q.isEmpty() && limit-- >= 0) {
			int size = q.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				// check if current poll square is target
				if (tmp[0] == target[0] && tmp[1] == target[1]) {
					return true;
				}
				// add all four directional neighbour
				for (int[] d : dir) {
					if (row + d[0] < 0 || col + d[1] < 0 || row + d[0] == 1000000 || col + d[1] == 1000000) {
						continue;
					}
					String neigh = (row + d[0]) + "_" + (col + d[1]);
					 System.out.println(neigh);
					if (!visited.contains(neigh) && !blocker.contains(neigh)) {
						q.offer(new int[] { row + d[0], col + d[1] });
					}
				}
			}
		}
		return false;

	}
}
