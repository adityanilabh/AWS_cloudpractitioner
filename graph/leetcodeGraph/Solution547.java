class Solution547 {
    class DSU{
        int[] parent;
        int maxSizeComponent;
        public DSU(int numberOfNode)
        {
            parent= new int[numberOfNode];
            for(int i=0;i<numberOfNode;i++)
            {
                parent[i]=i;
            }
            maxSizeComponent=numberOfNode;
        }
        public void union(int x,int y)
        {
            int parentX=find(x);
            int parentY= find(y);
            if(parentX==parentY)
            {
                return;
            }
            else
            {
                maxSizeComponent--;
                parent[parentX]=parentY;
            }
        }
        public int find(int x)
        {
            if(parent[x]!=x)
            {
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // use union find algorithm
        int numberOfNodes= isConnected.length;
        // dsu will contains parent int array and int that denote
        // max size of components(that is nodeNumber)
        // it will also contain find and union
        // whenever we make union, decrease the value of maxSizeComponent by 1
       DSU dsu= new DSU(numberOfNodes);
       for(int i=0;i<numberOfNodes;i++)
       {
           for(int j=0;j<numberOfNodes;j++)
           {
               if(isConnected[i][j]==1)
               {
                   dsu.union(i,j);
               }
           }
       }
       return dsu.maxSizeComponent;
    }
}