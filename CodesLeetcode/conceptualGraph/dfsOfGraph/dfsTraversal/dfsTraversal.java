
import java.util.*;
import java.lang.*;
import java.io.*;

// solution of code that i solved in GeekForGeeks


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>>adj,ArrayList<Boolean>visited,int presentIndex,ArrayList<Integer>result)
    {
        visited.set(presentIndex,true);
        result.add(presentIndex);
        for(int index=0;index<adj.get(presentIndex).size();index++)
        {
            int nextIndex = adj.get(presentIndex).get(index);

            if (!visited.get(nextIndex)) {
                dfs(adj, visited,nextIndex, result);
            }
        }
    }
    /*public void printOut(ArrayList<Integer>result)
    {
        for(int i=0;i<result.size();i++)
        {
            System.out.print(result.get(i)+" ");
        }
    } */
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Boolean>visited= new ArrayList<>(Collections.nCopies(V,false));
        ArrayList<Integer>result= new ArrayList<>();
        for(int index=0;index<V;index++)
        {
            if(!visited.get(index))
            {
                dfs(adj,visited,index,result);
            }
        }
       // printOut(result);
        return result;
      
    }
}
// driver code from gfg so credit goes to GeekForGeeks.
class dfsTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
