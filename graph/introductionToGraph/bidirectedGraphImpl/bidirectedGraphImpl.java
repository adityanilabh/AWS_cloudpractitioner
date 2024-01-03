import java.util.*;
class Graph {
    List<Set<Integer>> edges;
    final int size;

    Graph(int size) {
        this.size = size;
        edges = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            edges.add(new HashSet<>());
        }
    }

    public void insert(int sourceVertex, int destinationVertex) {
        if (isValidVertex(sourceVertex) && isValidVertex(destinationVertex)) {
            edges.get(sourceVertex).add(destinationVertex);
            edges.get(destinationVertex).add(sourceVertex);
        } else {
            System.out.println("Invalid vertex provided.");
        }
    }

    private boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < size;
    }

    // Other methods for graph operations

    public void print() {
        for (int index = 0; index < size; index++) {
            if (!edges.get(index).isEmpty()) {
                System.out.print((index) + " -> ");
                for (int i : edges.get(index)) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}

public class BidirectionalGraph {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.insert(2, 3);
        g.insert(3, 4);
        g.insert(5, 6);
        g.insert(6, 5);
        g.print();
    }
}
