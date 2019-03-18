package com.practice.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * a class for connected directed acyclic graph
 * 
 * @author sarveshkumar
 *
 */
public class ConnectedDAGraph {

	/**
	 * is this graph strongly connected
	 * @param graph
	 */
	public boolean isStronglyConnectedGraph(CustomGraph graph) {
		if (graph.getVertices().isEmpty()) {
			System.out.println("graph is empty");
			return false;
		}
		boolean isConnected = false;
		Vertex start = graph.getVertices().values().iterator().next();
		String startVertexName = start.getName();
		Set<Vertex> visited = new HashSet<>();
		int noOfVertex = graph.getVertices().values().size();
		DFSAdjList(graph, start, visited);
		if (visited.size() == noOfVertex) {
			//it means graph is connected . Now verify strongly connected graph condition. Reverse the edges of graph 
			//if we are still able to travel to all vertex from same starting vertex then it is strongly connected
			TransposeGraph tg = new TransposeGraph();
			graph  = tg.reverseDAGraphAdjList(graph);
			visited = new HashSet<>();
			start = graph.getVertex(startVertexName);
			DFSAdjList(graph, start, visited);
			if(visited.size() == noOfVertex){
				isConnected = true;
			}
			
		}
		return isConnected;
	}
	
	/**
	 * assuming graph is connected graph ,print all strongly connected components
	 * @param graph
	 */
	public void printStronglyConnectedComponents(CustomGraph graph) {
		if (graph.getVertices().isEmpty()) {
			System.out.println("graph is empty");
			return;
		}
		Vertex start = graph.getVertices().values().iterator().next();
		String startVertexName = start.getName();
		Set<Vertex> visited = new HashSet<>();
		// Reverse the edges of graph
		// find all the vertex that can be reached from start vertex
		TransposeGraph tg = new TransposeGraph();
		graph = tg.reverseDAGraphAdjList(graph);
		start = graph.getVertex(startVertexName);
		DFSAdjList(graph, start, visited);
		for (Vertex v : graph.getVertices().values()) {
			if (!visited.contains(v)) {
				System.out.println();
				DFSAdjList(graph, v, visited);
			}
		}
	}

	/**
	 * is give DAG is connected graph. this will only check weakly connected
	 * graph
	 * 
	 * @param graph
	 */
	public boolean isConnectedGraph(CustomGraph graph) {
		if (graph.getVertices().isEmpty()) {
			System.out.println("graph is empty");
			return false;
		}
		// a set to keep track of visited vertex
		Set<Vertex> visited = new HashSet<>();
		Vertex start = graph.getVertices().values().iterator().next();
		DFSAdjList(graph, start, visited);
		// if all vertex has been visited by staring from any random vertex. It
		// means graph is connected
		if (visited.size() == graph.getVertices().values().size()) {
			return true;
		}
		return false;
	}

	/**
	 * traverse through all vertex using DFS
	 * @param graph
	 * @param v
	 * @param visited
	 */
	private void DFSAdjList(CustomGraph graph, Vertex v, Set<Vertex> visited) {
		visited.add(v);
		System.out.print(v.getName()+" ");
		for (Vertex adjVertex : v.getAdjacentVertexes()) {
			// if adj node is not visited then call DFS with new adj node
			if (!visited.contains(adjVertex)) {
				DFSAdjList(graph, adjVertex, visited);
			}
		}

	}
	
}
