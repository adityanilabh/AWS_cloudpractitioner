// this is a snipppet code from leetcode. 

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // concept: for we have the edge matrix, so what we will do is taking all the vertex
        // let x from 1 to n, and then calculate all source vertex from a to b, with x as intermediate node
        // so we will use three loops
        
        // initialise the dist matrix,
        int[][] shortestDistance= new int[n][n];
        for(int rowIndex=0;rowIndex<n;rowIndex++)
        {
            for(int columnIndex=0;columnIndex<n;columnIndex++)
            {
                if(rowIndex==columnIndex)
                {
                    shortestDistance[rowIndex][columnIndex]=0;
                }
                   else
                {
                    shortestDistance[rowIndex][columnIndex]=Integer.MAX_VALUE;
                }
            }
        }

        // now initialise the value which are not zero
        for(int[] edge: edges)
        {
            int source= edge[0];
            int dest= edge[1];
            int weight= edge[2];
            shortestDistance[source][dest]=shortestDistance[source][dest]=weight;
        }

        // now make three loops
        for(int intermediateNode=0;intermediateNode<n;intermediateNode++)
        {
             for(int sourceNode=0;sourceNode<n;sourceNode++)
             {
                for(int destNode=0;destNode<n;destNode++)
                {
                     if(shortestDistance[sourceNode][intermediateNode]!=Integer.MAX_VALUE && shortestDistance[intermediateNode][destNode]!=Integer.MAX_VALUE)
                     {
                        shortestDistance[sourceNode][destNode]=Math.min(hortestDistance[sourceNode][destNode],shortestDistance[sourceNode][intermediateNode]+ shortestDistance[intermediateNode][destNode]);
                     }
                }
             }
        }

        printout(shortestDistance);
    }
}