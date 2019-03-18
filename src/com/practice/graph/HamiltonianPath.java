package com.practice.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HamiltonianPath {
	/**
	 * is there a hamiltonian path exists in DAG graph
	 * 
	 * @param graph
	 * @return
	 */
	public boolean isHamiltonialPathExists(CustomGraph graph) {
		Set<Vertex> visited = new LinkedHashSet<>();
		for (Vertex v : graph.getVertices().values()) {
			if (!visited.contains(v)) {
				List<Vertex> path = new LinkedList<>();
				if (DFSPath(graph, v, visited, path)) {
					return true;
				}

			}
		}

		return false;
	}

	/**
	 * traversal through graph
	 * 
	 * @param graph
	 * @param v
	 * @param visited
	 * @param path
	 * @return
	 */
	private boolean DFSPath(CustomGraph graph, Vertex v, Set<Vertex> visited, List<Vertex> path) {
		boolean isExist = false;
		if (visited.size() == graph.getVertices().size()) {
			return true;
		} else {
			for (Vertex adj : v.getAdjacentVertexes()) {
				if (!visited.contains(adj)) {
					visited.add(v);
					path.add(v);
					isExist = DFSPath(graph, adj, visited, path);
					if (!isExist) {
						visited.remove(adj);
						path.remove(adj);
					}
				}
			}
		}
		return isExist;

	}

}
