package com.practice.graph;

import java.util.HashSet;
import java.util.Set;

public class DijkastraAdjacencyMatix {

	public void Dijkastra(int[][] matrix, int src,int V) {
		int cost[] = new int[V];
		for (int i = 0; i < V; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		cost[src] = 0;
		Set<Integer> visited = new HashSet<>();
		visited.add(src);
		while (visited.size() < V) {
		}
	}

}
