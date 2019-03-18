package com.practice.graph;

public class TransposeGraph {

	/**
	 * reversing edge for DAG
	 * 
	 * @param graph
	 */
	public int[][] reverseDAGraphMatrix(int graph[][]) {
		// one solution would be to create a new graph object and if g[u][v]==1
		// then add g[v][u]=1
		int lenght = graph.length;
		int[][] tGraph = new int[lenght][lenght];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1) {
					tGraph[j][i] = 1;
				}
			}
		}
		return tGraph;

	}

	/**
	 * 
	 * @param graph
	 */
	public CustomGraph reverseDAGraphAdjList(CustomGraph graph) {
		CustomGraph tGraph = new CustomGraph();
		for (Vertex v : graph.getVertices().values()) {
			for (Edge e : v.getEdges()) {
				tGraph.addEdge(e.getTo(), e.getFrom(), e.getWeight(),true);
			}
		}
		return tGraph;

	}
	
	

}
