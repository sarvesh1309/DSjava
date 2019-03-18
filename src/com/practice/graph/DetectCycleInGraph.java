package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * find cycle in graph
 * 
 * @author sarveshkumar
 *
 */
public class DetectCycleInGraph {

	/**
	 * retun true if undirected graph contains a cycle
	 * 
	 * @param g
	 * @return
	 */
	public boolean isCyclicUndirectedGraph(CustomGraph g) {
		Set<Vertex> visited = new HashSet<>();
		Map<Vertex, Vertex> parent = new HashMap<>();
		for (Vertex v : g.getVertices().values()) {
			if (!visited.contains(v)) {
				parent.put(v, null);
				if (DFShelper(g, visited, v, parent)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * helper class to check if any cycle exists in graph from given staring
	 * vertex
	 * 
	 * @param g
	 * @param visited
	 * @param v
	 * @param parent
	 * @return
	 */
	private boolean DFShelper(CustomGraph g, Set<Vertex> visited, Vertex v, Map<Vertex, Vertex> parent) {
		visited.add(v);
		boolean isCyclic = false;
		for (Vertex adj : v.getAdjacentVertexes()) {
			if (visited.contains(adj)) {
				// if adjacent node has been visited and it is the immediate parent then it means this is a back edge from current node v to node adj
				// confirms a back edge
				if (parent.get(v) != adj) {
					return true;
				}
			} else {
				parent.put(adj, v);
				isCyclic = DFShelper(g, visited, adj, parent);
				if (isCyclic) {
					break;
				}
			}
		}
		return isCyclic;
	}

	/**
	 * return true if there is a cycle in given acyclic directed graph
	 * 
	 * @param graph
	 * @return
	 */
	public boolean isCyclicDAGGraph(CustomGraph graph) {
		Set<Vertex> neverVisited = new HashSet<>();
		Set<Vertex> visitedInProcess = null;
		Set<Vertex> visitCompleted = null;
		for (Vertex v : graph.getVertices().values()) {
			neverVisited.add(v);
		}
		for (Vertex v : graph.getVertices().values()) {
			if (neverVisited.contains(v)) {
				visitedInProcess = new HashSet<>();
				visitCompleted = new HashSet<>();
				if (DFSDAGHelper(v, neverVisited, visitedInProcess, visitCompleted)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * DAG helper
	 * 
	 * @param v
	 * @param neverVisited
	 * @param visitedInProcecc
	 * @param visitCompleted
	 * @return
	 */
	private boolean DFSDAGHelper(Vertex v, Set<Vertex> neverVisited, Set<Vertex> visitedInProcecc,
			Set<Vertex> visitCompleted) {
		moveVertex(neverVisited, visitedInProcecc, v);
		for (Vertex adj : v.getAdjacentVertexes()) {
			// if adj node has already been processed then move to next adj node
			if (visitCompleted.contains(adj)) {
				continue;
			}
			// if adjacent vertex is a ancestor of current vertex then it
			// represents a cycle
			if (visitedInProcecc.contains(adj)) {
				return true;
			}
			if (DFSDAGHelper(adj, neverVisited, visitedInProcecc, visitCompleted)) {
				System.out.println(adj.getName());
				return true;
			}

		}
		moveVertex(visitedInProcecc, visitCompleted, v);
		return false;
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 * @param vertex
	 */
	private void moveVertex(Set<Vertex> source, Set<Vertex> destination, Vertex vertex) {
		source.remove(vertex);
		destination.add(vertex);
	}

}