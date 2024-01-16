// step 1: what we will do is count all the edges. 
// step 2: then count all the vertex as well.
// step 3: run a loop from 1 to no_of_vertex-1. then update the shortest distance.
//  maintain a shortest distance array as well.
//step 4:  now after iterating for no_of_vertex-1, do one more iteration to check for negative cycle. 
// step 5: return the shortest path from one node to other nodes.

/* following code snippet from a questino in leetcode:
*/
import java.util.*;
class bellManFord {
    public int[] networkDelayTime(int[][] times, int n, int k) {
        int[] shortestPath= new int[n+1];
        Arrays.fill(shortestPath,Interger.MAX_VALUE);
        shortestPath[k]=0;
        // initialise the iteration for vertex 1 to n-1
        for(int i=1;i<n;i++)
        {
            // iterate the edges now: 
            for(int[] edges: times)
            {
                int src= edges[0];
                int dest= edges[1];
                int weight= edges[2];
                if(shortestPath[dest]!=Integer.MAX_VALUE && shortestPath[src]+weight<shortestPath[dest])
                {
                    shortestPath[dest]=shortestPath[src]+weight;
                }
            }
        }

        // negative cycle detection
        for(int[] edge: times)
        {
            int src= edges[0];
            int dest= edges[1];
            int weight= edges[2];
            if(shortestPath[dest]!=Integer.MAX_VALUE && shortestPath[src]+weight<shortestPath[dest])
            {
                return new int[];
            }
        }
        return shortestPath;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int[] result = solution.networkDelayTime(times, n, k);
        System.out.println("Output: " + result);
    }
}
