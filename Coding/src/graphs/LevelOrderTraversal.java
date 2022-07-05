package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> graph;
		Graph graphObject = new Graph();
		graph = graphObject.getGraph();
		int n = graph.size();
		// graphObject.printAdjacencyList();

		int[] visited = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				traverse(graph, visited, i);
			}
		}
	}

	private static void traverse(ArrayList<ArrayList<Integer>> graph, int[] visited, int node) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(node);
		int n = q.size();
		
		while (!q.isEmpty()) {
			int tempNode = q.poll();
			System.out.println(tempNode);
			if (visited[tempNode] == 0)
				visited[tempNode] = 1;
			for (int i : graph.get(tempNode)) {
				if (visited[i] == 0)
					q.add(i);
			}
		}
	}
}
