import java.util.*;

class UnionFind {
    // make a parent array
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent= new int[n];
        rank= new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }

    // Find operation with path compression
    private int find(int x) {
          if(parent[x]==x)
          {
            return parent[x];
          }
          return parent[x]= find(parent[x]);
    }

    // Union operation with rank optimization
    public void union(int x, int y) {
        int parentx= find(x);
        int parenty=find(y);
        if(parentx!=parenty)
        {
            if(rank[parentx]>rank[parenty])
            {
               parent[parenty]=parentx;
            }
            else if(rank[y]>rank[x])
            {
                parent[parentx]=parenty;
            }
            parent[parentx]=parenty;
            rank[parenty]++;
        } 
    }

    // Function to determine if two vertices are in the same connected component
    public boolean isConnected(int x, int y) {
        if(parent[x]==parent[y])
        {
            return true;
        }
        return false;
    }
}

public class UnionFind {
    public static void main(String[] args) {
        int vertices = 6;
        UnionFind uf = new UnionFind(vertices);

        // Example edges forming connected components
        int[][] edges = {
            {0, 1},
            {1, 2},
            {3, 4},
            {4, 5}
        };

        // Union operation for each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            uf.union(u, v);
        }

        // Check if vertices are in the same connected component
        System.out.println("Connected Components:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + uf.find(i));
        }
    }
}
