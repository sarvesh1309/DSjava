package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

public class ArticulationVertex_AdjMatrix {
	/**
	 * considering node of matrixes are starting from 0.....n-1
	 * @param graph
	 */
	public void printArticulationVertex(int [][] graph){
		
		int startNode=0;
		int num = 0;
		int[] dfsnum = new int[graph.length];
		int[] low  = new int[graph.length];
		//initating to -1 as unvisited node
		for(int i=0;i<graph.length;i++){
			dfsnum[i]=-1;
		}
		Map<Integer,Integer> parent =  new HashMap<>();
		parent.put(startNode, null);
		dfstree(graph,dfsnum,low,startNode,parent,num);
		
		
	}

	private void dfstree(int[][] graph, int[] dfsnum, int[] low, int node, Map<Integer, Integer> parent, int num) {
		num = num + 1;
		int childCount = 0;
		dfsnum[node] = low[node] = (num);
		for (int v = 0; v < graph.length; v++) {
			if (graph[node][v] == 1) {
				if (dfsnum[v] == -1) {
					childCount++;
					parent.put(v, node);
					dfstree(graph, dfsnum, low, v, parent, num);
					// if low of a node v is greater than the dfsnum of parent
					// node u then u is cut vertex. This is only applicable for
					// non root vertex
					if (parent.get(node)!=null && low[v] >= dfsnum[node]) {
						System.out.println("cut vertex" + (node));
					}
					low[v] = Math.min(low[v], low[node]);
				} else {
					low[node] = Math.min(low[node], dfsnum[v]);
				}
			}
		}
		if (parent.get(node) == null && childCount >= 2) {
			System.out.println("cut vertex" + (node));
		}

	}

}
