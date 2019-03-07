package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleInGraph {

	public boolean isCyclicGraphDFS(int[][] g) {
		int visited[] = new int[g.length];
		for (int i = 0; i < g.length; i++) {
			visited[i] = 0;
		}
		boolean isCyclic = false;
		Map<Integer, Integer> parent = new HashMap<>();
		for (int i = 0; i < g.length; i++) {
			if (visited[i] == 0 && !isCyclic) {
				parent.put(i, null);
				return DFS(g, i, visited, parent);
			}
		}
		return false;
	}

	private boolean DFS(int[][] g, int start, int[] visited, Map<Integer, Integer> parent) {
		visited[start] = 1;
		for (int i = 0; (i < g.length); i++) {
			if (g[start][i] == 1) {
				if (visited[i] == 0) {
					parent.put(i, start);
					return DFS(g, i, visited, parent);
				}
				if (!(parent.get(start) == i)) {
					return true;
				}
			}
		}
		return false;
	}
}