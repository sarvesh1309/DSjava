package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MyGraphImpl implements MyGraph {
	
	Map<Vertex,Set<Vertex>> graphList;
	Map<String,Vertex> vertices;
	Set<Edge> edges;
	
	public MyGraphImpl() {
		graphList = new HashMap<Vertex,Set<Vertex>>();
		vertices = new HashMap<String,Vertex>();
		edges = new HashSet<Edge>();
	}

	@Override
	public Vertex addVertex(String name) {
		Vertex v = getVertex(name);
		if (v == null) {
			v = new Vertex(name);
			vertices.put(name, v);
			graphList.put(v, new LinkedHashSet<Vertex>());
		}
		return v;
	}
	

	@Override
	public void addEdge(String from, String to) {
		addEdge(from, to,false);
	}
	
	@Override
	public void addEdge(String from, String to, boolean isDirected) {
	addEdge(from, to, isDirected, 1);
	}


	@Override
	public void addEdge(String from, String to, boolean isDirected,int weight) {
		Vertex v1 = addVertex(from);
		Vertex w1 = addVertex(to);
		if (hasEdge(from, to)) {
			System.out.println("edge already presents");
		} else {
			Edge enew = new Edge(from, to, weight);
			v1.setAdjacentVertex(enew,w1);
			edges.add(enew);
			if (!isDirected) {
				enew  = new Edge(to, from, weight);
				w1.setAdjacentVertex(enew,v1);
				edges.add(enew);
			}
		}

	}
	
	
	@Override
	public boolean isNeighbour(Vertex v, Vertex w) {
		Set<Vertex> neighboursV = getNeighbour(v);
		if(neighboursV!=null && neighboursV.contains(w)) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Vertex> getNeighbour(Vertex v) {
	   return graphList.get(v);
	}

	@Override
	public void removeVertex(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vertex getVertex(String name) {
		if(vertices.containsKey(name)) {
			return vertices.get(name);
		}
		return null;
	}

	@Override
	public void removeEdge(String v, String w) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return graphList.size();
	}

	@Override
	public Map<String,Vertex> getVertices() {
		return vertices;
	}

	@Override
	public boolean isNeighbour(String v, String w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getNeighbour(String v) {
		Set<String> neighboursName = null;
		if (vertices.containsKey(v)) {
			Vertex vertex = vertices.get(v);
			Set<Vertex> neighbourNode = graphList.get(vertex);
			neighboursName = new HashSet<String>();
			for (Vertex vertex2 : neighbourNode) {
				neighboursName.add(vertex2.getName());
			}
		}
		return neighboursName;
	}

	@Override
	public boolean hasEdge(String from, String to) {
		boolean hasEdge = false;
		if (vertices.containsKey(from)) {
			if (getNeighbour(from).contains(to)) {
				hasEdge = true;
			}
		}
		return hasEdge;
	}

	@Override
	public Set<Edge> getEdges() {
		return edges;
	}

	

}
