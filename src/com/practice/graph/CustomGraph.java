package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CustomGraph {

	Map<Vertex, Set<Vertex>> graph;
	Map<String, Vertex> vertices;
	Set<Edge> edges;

	public CustomGraph() {
		graph = new HashMap<Vertex, Set<Vertex>>();
		vertices = new HashMap<String, Vertex>();
		edges = new HashSet<Edge>();

	}

	/**
	 * add vertex with given name if it does not exist
	 * 
	 * @param name
	 * @return Vertex
	 */
	public Vertex addVertex(String name) {
		Vertex vertex;
		if ((vertex = getVertex(name)) != null) {
			return vertex;
		} else {
			vertex = new Vertex(name);
			graph.put(vertex, new LinkedHashSet<Vertex>());
			vertices.put(name, vertex);
		}
		return vertex;
	}

	

	/**
	 * add an edge source to destination node if it does not exist . This method is
	 * applicable for non directed graph
	 * 
	 * @param from
	 * @param to
	 * @param weight
	 * @return
	 */
	public Edge addEdge(String from, String to, int weight) {
		return addEdge(from, to, weight, false);

	}

	/**
	 * add an edge source to destination node if it does not exist . Parameter can
	 * be passed to create a directed or non directed edge
	 * 
	 * @param from
	 * @param to
	 * @param weight
	 * @param directed
	 * @return
	 */
	public Edge addEdge(String from, String to, int weight, boolean isDirected) {
		Edge edge;
		if ((edge = getEdge(from, to)) != null) {
			return edge;
		} else {
			edge = new Edge(from, to, weight);
			Vertex fromNode = addVertex(from);
			Vertex toNode = addVertex(to);
			graph.get(fromNode).add(toNode);
			fromNode.setAdjacentVertex(edge, toNode);
			edges.add(edge);
			if (!isDirected) {
				graph.get(toNode).add(fromNode);
				toNode.setAdjacentVertex(edge, fromNode);
			}
		}
		return edge;

	}

	public Map<String, Vertex> getVertices() {
		return vertices;

	}

	public Set<Edge> getEdges() {
		return edges;

	}
	
	/**
	 * if graph contains the vertex then return otherwise return null
	 * 
	 * @param name name of vertex
	 * @return
	 */
	public Vertex getVertex(String name) {
		return vertices.get(name);
	}
	
	/**
	 * if graph contains the Edge then return otherwise return null
	 * 
	 * @param edge Edge
	 * @return
	 */
	public Edge getEdge(String from, String to) {
		Vertex fromNode = getVertex(from);
		Vertex toNode = getVertex(to);
		if (fromNode != null && toNode != null && fromNode.getAdjacentVertexes().contains(toNode)) {
			for (Edge tmpEdge : fromNode.getEdges()) {
				if (tmpEdge.getFrom().equals(from) && tmpEdge.getTo().equals(to)) {
					return tmpEdge;
				}
			}
		}

		return null;

	}

}
