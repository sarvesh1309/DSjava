package com.practice.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.practice.queue.Queue;

public class GraphBasicOperations {

	private Map<Vertex,Boolean> visited= null;

	public void DFS(MyGraph g) {
		visited = new HashMap<Vertex, Boolean>();
		for (Vertex v : g.getVertices().values()) {
			visited.put(v, false);
		}
		for (Vertex v : g.getVertices().values()) {
			if (!visited.get(v)) {
				DFSHelper(g, v);
			}
		}
	}

	private void DFSHelper(MyGraph g, Vertex v) {
        visited.put(v, true);
        System.out.println(v.getName());
        for(Vertex neigh:g.getNeighbour(v)) {
        	if(!visited.get(neigh)){
        		DFSHelper(g, neigh);
        	}
        }
	}
	
	public void BFS(MyGraph g) {
		System.out.println("BFS method entry");
		visited = new HashMap<Vertex, Boolean>();
		for (Vertex v : g.getVertices().values()) {
			visited.put(v, false);
		}
		
		for (Vertex v : g.getVertices().values()) {
			if (!visited.get(v)) {
				
				BFSHelper(g,v);
			}
		}
	}

	private void BFSHelper(MyGraph g, Vertex v) {
		Queue q = new Queue();
		q.enQueue(v);
		while (!q.isEmpty()) {
			Vertex tmp = (Vertex) q.deQueue();
			if (!visited.get(tmp)) {
				System.out.println(tmp.getName());
				visited.put(tmp, true);
				for (Vertex neigh : g.getNeighbour(tmp)) {
					q.enQueue(neigh);
				}
			}
		}
	}
	
	

	//Dijkastra implementation for Adjacency matrix without using priority queue . O(N^2)
	public void DijkastraAlgo(int g[][], int source) {
		int NodeCount = g.length;
	    int cost[] = new int[NodeCount];
	    Arrays.fill(cost, Integer.MAX_VALUE);
	    Set<Integer> visited = new HashSet<Integer>();
	    Map<Integer,Integer> predecessors = new HashMap<Integer,Integer>();
	    cost[source]=0;
	    predecessors.put(0, null);
	    while(visited.size()!=NodeCount) {
	    	int minDistCity = -1;
	    	int minDistance = Integer.MAX_VALUE;
	    	for(int i=0;i<NodeCount;i++) {
	    		if(!visited.contains(i)) {
	    			if(cost[i]<minDistance) {
	    				minDistance = cost[i];
	    				minDistCity = i;
	    			}
	    		}
	    	}
	    	if(minDistCity==-1) {
	    		break;
	    	}
	    	visited.add(minDistCity);
	    	cost[minDistCity] = minDistance;
	    	for(int i=0;i<NodeCount;i++) {
	    		if(g[minDistCity][i]!=0 && !visited.contains(i)) {
	    			int costnew = cost[minDistCity]+g[minDistCity][i];
	    			if(costnew<cost[i]) {
	    				cost[i]=costnew;
	    				predecessors.put(i, minDistCity);
	    			}
	    		}
	    	}
	    	
	    }
	    
	    for(int i=0;i<NodeCount;i++) {
	    	System.out.println("count to : "+i+" is : "+cost[i]);
	    }
	    
	   // printAllpath(predecessors,6);
	    
	}

/*	private void printAllpath(Map<Integer, Integer> predecessors,int target) {
		if(predecessors.get(target)==null) {
			System.out.println(target);
			return;
		}
		if(predecessors.containsKey(target)) {
			System.out.println(target + "<-");
			printAllpath(predecessors, predecessors.get(target));
		}
	}*/
	
	
	//implementation of Dijkastra algo using Priority queue and Adjacency list
	public void DijkastraAlgo(CustomGraph g, String source) {
		Vertex sourceNode = g.getVertex(source);
		if (sourceNode == null) {
			System.out.println("source node does not exist");
			return;
		}
		Map<String, Integer> costInit = new HashMap<String, Integer>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> predecessors = new HashMap<String, String>();
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		for (String str : g.getVertices().keySet()) {
			costInit.put(str, Integer.MAX_VALUE);
		}
		costInit.put(source, 0);
		pq.add(new Vertex(source, 0));
		predecessors.put(source, null);
		while (!pq.isEmpty()) {
			Vertex tmp = pq.remove();
			visited.add(tmp.getName());
			for (Edge edge : g.getVertex(tmp.getName()).getEdges()) {
				if (!visited.contains(edge.getTo())) {
					int cost = costInit.get(tmp.getName()) + edge.getWeight();
					if (cost < costInit.get(edge.getTo())) {
						costInit.put(edge.getTo(), cost);
						predecessors.put(edge.getTo(), tmp.getName());
						pq.add(new Vertex(edge.getTo(), cost));
					}
				}
			}
		}
		  for(String city :costInit.keySet()) {
		    	System.out.println("cost to : "+city+" is : "+costInit.get(city));
		    }
		    

	}

	private void printAllpath(Map<String, String> predecessors, String target) {
		if(predecessors.get(target)==null) {
			System.out.println(target);
			return;
		}
		if(predecessors.containsKey(target)) {
			System.out.println(target + "<-");
			printAllpath(predecessors, predecessors.get(target));
		}
		
	}
	
	public void Bellman_FordAlgo(CustomGraph g, String source) {
		Map<String,Integer> costinit  = new HashMap<String,Integer>();
		Map<String,String> predecessor = new HashMap<String,String>();
		for(String str:g.vertices.keySet()) {
			costinit.put(str, Integer.MAX_VALUE);
		}
		costinit.put(source, 0);
		for(int i=1;i<=g.getVertices().size()-1;i++) {
			for(Edge edge:g.getEdges()) {
				if(costinit.get(edge.getFrom())==Integer.MAX_VALUE) {
					continue;
				}
				int distance  = costinit.get(edge.getFrom())+edge.getWeight();
				if(costinit.get(edge.getTo())>(distance)){
					predecessor.put(edge.getTo(), edge.getFrom());
					costinit.put(edge.getTo(), distance);
				}
			}
		}
		 for(String city :costinit.keySet()) {
		    	System.out.println("cost to : "+city+" is : "+costinit.get(city));
		    }
		 
		
	}
	
	
	
}
