package com.practice.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Vertex implements Comparable<Vertex> {

	private String name;
	private int weight;
	private Set<Edge> edges;
	private Set<Vertex> vertexes;

	public Vertex(String name) {
		this.name = name;
		edges = new HashSet<Edge>();
		vertexes = new HashSet<Vertex>();
	}

	public Vertex(String name, int weight) {
		this.name = name;
		this.weight = weight;
		edges = new HashSet<Edge>();
		vertexes = new HashSet<Vertex>();
	}

	public void setAdjacentVertex(Edge e, Vertex v) {
		vertexes.add(v);
		edges.add(e);
	}

	public String getName() {
		return name;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Set<Vertex> getAdjacentVertexes() {
		return vertexes;
	}

	@Override
	public int compareTo(Vertex o2) {
		if (this.weight < o2.weight) {
			return -1;
		} else if (this.weight > o2.weight) {
			return 1;
		} else {
			return 0;
		}
	}

}
