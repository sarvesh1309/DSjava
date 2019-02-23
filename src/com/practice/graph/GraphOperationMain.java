package com.practice.graph;

public class GraphOperationMain {

	public static void main(String[] args) {

		MyGraph graph = new MyGraphImpl();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		
		//adding edges 
		
		graph.addEdge("A", "B",false);
		graph.addEdge("B", "C",false);
		graph.addEdge("B", "H",false);
		graph.addEdge("C", "D",false);
		graph.addEdge("C", "E",false);
		graph.addEdge("E", "F",false);
		graph.addEdge("E", "H",false);
		graph.addEdge("E", "G",false);
		
		GraphBasicOperations gb = new GraphBasicOperations();
		//gb.DFS(graph);
		//gb.BFS(graph);
		
		
		int[][] matrixGraph = new int[][] { 
			  {0,5,0,0,0,0,0,0,0},
			  {0,0,6,2,0,0,0,0,0},
			  {0,0,0,0,3,0,0,0,0},
			  {0,0,0,0,4,0,0,0,0},
			  {0,0,0,0,0,0,0,3,0},
			  {3,0,0,0,0,0,1,0,0},
			  {0,0,0,0,0,0,0,7,0},
			  {0,0,0,0,0,0,0,0,8},
			  {0,0,0,0,0,4,0,0,0}
		};
		//gb.DijkastraAlgo(matrixGraph, 0);
		
		
		CustomGraph g= new CustomGraph();
		g.addEdge("0", "1", 5,true);
		g.addEdge("1", "2", 3,true);
		g.addEdge("1", "3", 2,true);
		g.addEdge("2", "4", 2,true);
		g.addEdge("3", "4", 4,true);
		g.addEdge("4", "7", 3,true);
		g.addEdge("5", "1", 3,true);
		g.addEdge("5", "6", 1,true);
		g.addEdge("6", "7", 7,true);
		g.addEdge("7", "8", 8,true);
		g.addEdge("7", "3", 10,true);
		g.addEdge("8", "5", 4,true);
		
		//gb.DijkastraAlgo(g, "0");
		
	//	gb.Bellman_FordAlgo(g, "0");
		
		CustomGraph g1= new CustomGraph();
		g1.addEdge("0", "1", 4,true);
		g1.addEdge("0", "3", 6,true);
		g1.addEdge("3", "2", -1,true);
		g1.addEdge("2", "1", -2,true);
		
		// Dijkastra algo will not work with negative edge 
        gb.DijkastraAlgo(g1, "0");
		
		gb.Bellman_FordAlgo(g1, "0");
		
		
	}

}
