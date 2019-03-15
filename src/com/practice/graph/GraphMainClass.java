package com.practice.graph;

public class GraphMainClass {

	public static void main(String s[]) {
		int g[][] = new int[][]{{0,1,0,0},{0,0,1,0},{1,0,0,0},{0,0,1,0}};
		CountConnectedComponentsGraph cg = new CountConnectedComponentsGraph();
		System.out.println("connected compo : "+cg.countConnectedComponents(g));

	}

}
