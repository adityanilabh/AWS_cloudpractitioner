
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    private boolean dfs(ArrayList<ArrayList<Integer>>adj,int [] colour,int node,int whichColour)
    {
        colour[node]=whichColour;
        for(int index=0;index<adj.get(node).size();index++)
        {
            int next=adj.get(node).get(index);
            if(colour[next]==whichColour)
            {
                return false;
            }
            if(colour[next]==-1 && !dfs(adj,colour,next,1-whichColour))
            {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int[] colour= new int[V];
        Arrays.fill(colour,-1);
        for(int i=0;i<V;i++)
        {
            if(colour[i]==-1 && !dfs(adj,colour,i,0))
            {
                return false;
            }
        }
        return true;
        
    }
}


class isBipartite
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}



