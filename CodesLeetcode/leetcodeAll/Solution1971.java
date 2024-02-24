class Solution1971 {
    public int find(int x,int[] parent)
    {
         if(parent[x]!=x)
         {
             return parent[x]=find(parent[x],parent);
         }
        return parent[x]=x;
    }
    public void union(int src,int dest, int[] parent)
    {
        int parentX=find(src,parent);
        int parentY=find(dest,parent);
        if(parentX==parentY)
        {
            return;
        }
        parent[parentX]=parent[parentY];
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // can be done with dfs as well as disjoint set union..
        // let's solve it with disjoint set union
        
        int[] parent= new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            int src=edges[i][0];
            int dest=edges[i][1];
            union(src,dest,parent);
        }
        return find(source,parent)==find(destination,parent);
    }
}