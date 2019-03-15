package com.practice.graph;

public class CountConnectedComponentsGraph {

	public int countConnectedComponents(int[][] graph) {
		int count = 0;
		boolean visited[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) {
				DFS(graph, i, visited);
				count++;
			}
		}
		return count;
	}

	private void DFS(int[][] graph, int start, boolean[] visited) {
		visited[start] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[start][i] == 1 && !visited[i])
				DFS(graph, i, visited);
		}
	}

}
