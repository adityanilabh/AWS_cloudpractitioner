/* attempted by Nilabh Aditya */
import java.util.ArrayList;
import java.util.List;

class Graph {
	
	static void addEdge(List<List<Integer>> adjacencyList, int source, int destination) {
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}

	static void depthFirstSearch(int vertex, List<List<Integer>> adjacencyList, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");

		for (int adjacentVertex : adjacencyList.get(vertex)) {
			if (!visited[adjacentVertex]) {
				depthFirstSearch(adjacentVertex, adjacencyList, visited);
			}
		}
	}

	static void performDFS(List<List<Integer>> adjacencyList, int numberOfVertices) {
		boolean[] visited = new boolean[numberOfVertices];

		for (int vertex = 0; vertex < numberOfVertices; vertex++) {
			if (!visited[vertex]) {
				depthFirstSearch(vertex, adjacencyList, visited);
			}
		}
	}

	public static void main(String[] args) {
		int numberOfVertices = 5;

		List<List<Integer>> adjacencyList = new ArrayList<>(numberOfVertices);

		for (int i = 0; i < numberOfVertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}

		addEdge(adjacencyList, 0, 1);
		addEdge(adjacencyList, 0, 4);
		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 1, 3);
		addEdge(adjacencyList, 1, 4);
		addEdge(adjacencyList, 2, 3);
		addEdge(adjacencyList, 3, 4);

		performDFS(adjacencyList, numberOfVertices);
	}
}
