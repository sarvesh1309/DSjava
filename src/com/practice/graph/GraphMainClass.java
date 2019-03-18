package com.practice.graph;

public class GraphMainClass {

	public static void main(String s[]) {
		CustomGraph g = new CustomGraph();
		g.addEdge("A", "B", 1, false);
		g.addEdge("B", "C", 1, false);
		g.addEdge("G", "E",1, false);
		g.addEdge("C", "D",1, false);
		g.addEdge("C", "E", 1, false);
		
		DetectCycleInGraph dg = new DetectCycleInGraph();
		System.out.println(dg.isCyclicUndirectedGraph(g));
		
		

	}

}
