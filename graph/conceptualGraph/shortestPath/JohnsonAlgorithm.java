// code snippet from leetcode
class JohnsonAlgorithm {

    private int[] bellmanFord(List<int[]>edges,int n)
    {
        int[] shortestDistance=new int[];
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        shortestDistance[n]=0;

        // traverse the graph n-1 time
        for(int i=0;i<n-1;i++)
        {
             for(int[] edge: edges)
             {
                 if(shortestDistance[edge[0]]!=Interger.MAX_VALUE && shortestDistance[edge[0]]+edge[2]<shortestDistance[edge[1]])
                 {
                    shortestDistance[edge[1]]=shortestDistance[edge[0]]+edge[2];
                 }
             }
        }
        for (int[] edge : edges) {
            if (shortestDistance[edge[0]] != Integer.MAX_VALUE &&
                    shortestDistance[edge[0]] + edge[2] < shortestDistance[edge[1]]) {
                throw new IllegalStateException("Graph contains negative cycle");
            }
        }
        return shortestDistance;

    }
    public int[][] findTheCity(int n, int[][] edges, int distanceThreshold) {
        // approach is that first we make a node, connect it to all other nodes, then 
        // use bellman ford algorithm(to detect negative cycle as well as overcome negative weight)
        // then apply djastra algorithm and remove the node.

        // first create an arraylist 
        List<int[]>edgeList= new ArrayList<>();
        for(int[] edge: edges)
        {
            edgeList.add(new int[]{edge[0],edge[1],edge[2]});
        }
        // then make a node and connect that node to all other node with weight 0;
        for(int i=0;i<n;i++)
        {
            edgeList.add(new int[]{n,i,0});
        }
        // now run a bell man ford algorithm;
        int[] shortestPath= bellmanFord(edgeList,n+1);

        // now reweight the graph using algo edge[2]+shortestDistance[edge[0]]-shortestDistance[edge[1]];

        for(int[] edge: edges)
        {
            edge[2]+=shortestDistance[edge[0]]-shortestDistance[edge[1]];
        }
        // now djastra algorithm use kro
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] dijkstraDistances = dijkstra(n, edgeList, i);
            System.arraycopy(dijkstraDistances, 0, result[i], 0, n);
        }
        return result;

    }
}