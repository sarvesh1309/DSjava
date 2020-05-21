package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkastraAdjacencyMatixPQ {
	static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V) {
		// add your code
		PriorityQueue<Node> pq = new PriorityQueue<>((Node v1, Node v2) -> v1.weight - v2.weight);
		int[] cost = new int[V];
		for (int i = 0; i < V; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		boolean[] visited = new boolean[V];
		pq.add(new Node(src, 0));
		cost[src] = 0;
		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int index = tmp.v;
			visited[index] = true;
			List<Integer> neigh = list.get(index);
			for (int i = 0; i < V; i++) {
				if (neigh.get(i) != 0 && !visited[i]) {
					int costVal = tmp.weight + neigh.get(i);
					if (costVal < cost[i]) {
						pq.add(new Node(i, costVal));
						cost[i] = costVal;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++) {
			sb.append(cost[i]).append(" ");
		}
		System.out.print(sb.toString());
	}

}

class Node {
	int v;
	int weight;

	public Node(int v, int wt) {
		this.v = v;
		this.weight = wt;
	}
}
