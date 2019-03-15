package com.practice.graph;

/**
 * depth of directed acyclic graph
 * 
 * @author sarveshkumar
 *
 */
public class DepthOfDAG {

	public int depthDAG(int[][] graph) {
		int depth = 0;
		boolean visited[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) {
				DFS(graph, i, visited, depth);
			}
		}
		return depth;
	}

	private void DFS(int[][] graph, int start, boolean[] visited, int depth) {
		visited[start] = true;
		depth++;
		for (int i = 0; i < graph.length; i++) {
			if (graph[start][i] == 1 && !visited[i])
				DFS(graph, i, visited, depth);
		}
	}

}
