import java.util.*;

class Graph {
    private int V; // Number of vertices
    private Map<Integer, List<int[]>> adjList;

    public Graph(int vertices) {
        V = vertices;
        adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
    }

    public int[] shortestPaths(int source) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Perform topological sorting
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Process vertices in topological order and update shortest distances
        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }

        return distances;
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int[] neighbor : adjList.get(v)) {
            int u = neighbor[0];
            if (!visited[u]) {
                topologicalSortUtil(u, visited, stack);
            }
        }

        stack.push(v);
    }
}

public class AcyclicGraphShortestPath {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Add directed edges with weights
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 5, 1);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        int source = 1;

        // Find shortest paths from the source vertex
        int[] shortestPaths = graph.shortestPaths(source);

        // Print the shortest paths
        System.out.println("Shortest Paths from Source " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + ": " + shortestPaths[i]);
        }
    }
}
