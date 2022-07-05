package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	ArrayList<ArrayList<Integer>> adjacencyList;
	int[][] graph = { { 1, 2 }, { 0, 3 }, { 4, 1 } }; // JUST NEED TO UPDATE THIS 2D ARRAY FOR ANOTHER GRAPH
	int n; // FOR NUMBER OF NODES, ALL NODES MAY OR MAY NOT FORM A PART OF THE GRAPH

	Graph() {
		adjacencyList = new ArrayList<ArrayList<Integer>>();
		n = 5;

		for (int i = 1; i <= n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		buildGraph();
	}

	public void buildGraph() {
		for (int[] edge : graph) {
			adjacencyList.get(edge[0]).add(edge[1]);
		}

	}

	public ArrayList<ArrayList<Integer>> getGraph() {
		return adjacencyList;
	}

	public void printAdjacencyList() {
		for (List<Integer> list : adjacencyList)
			System.out.println(list);
	}

}
