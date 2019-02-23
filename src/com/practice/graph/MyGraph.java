package com.practice.graph;

import java.util.Map;
import java.util.Set;

public interface MyGraph {
	
	public Vertex addVertex(String name);
	
	public void addEdge(String v, String w);
	
	public void addEdge(String v, String w, boolean bidirectional);
	
	public void addEdge(String v, String w, boolean bidirectional,int weight);
	
	
	public boolean isNeighbour(String v , String w);
	
	public boolean isNeighbour(Vertex v , Vertex w);
	
	public Set<Vertex> getNeighbour(Vertex v);
	
	public Set<String> getNeighbour(String v);
	
	public void removeVertex(String name);
	
	public Vertex getVertex(String name);
	
	public void removeEdge(String v,String w);
	
	public int size();
	
	public Map<String,Vertex> getVertices();
	
	public Set<Edge> getEdges();
	
	public boolean hasEdge(String v, String w);
	

	
	
	
	
	

}
