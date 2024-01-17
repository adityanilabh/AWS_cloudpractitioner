import java.util.*;

class Graph {
    private int V; // Number of vertices
    private Map<Integer, List<Integer>> adjList;

    public Graph(int vertices) {
        V = vertices;
        adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void topologicalSort() {
       // initialise a stack
       Stack<Integer>result;
       // create a boolean visited array:
       boolean[] visited= new boolean[V];
       Arrays.fill(visited,false);
       for(int index=0;index<V;index++)
       {
          if(!visited[index])
          {
             dfs(index,visited,result);
          }
       }

       //printing the output:
       printout(result);
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
          visited[v]=true;
          for(int element: adjList.get(v))
          {
              if(!visited[element])
              {
                dfs(element,visited,stack);
              }
          }
          stack.push(v);
    }

    private void printout(Stack<Integer>result)
    {
        while(!result.isEmpty())
        [
            System.out.println(result.pop()+" ");
        ]
    }
}

public class TopologicalSortExample {
    public static void main(String[] args) {
        // Create a directed acyclic graph
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Perform topological sorting
        graph.topologicalSort();
    }
}
