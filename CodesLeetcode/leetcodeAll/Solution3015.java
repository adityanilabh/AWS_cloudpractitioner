class Solution3015 {
    public void FloydWarshall(int[][]graph,int n)
    {
        for(int k=0;k<=n;k++)
        {
            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=n;j++)
                {
                    graph[i][j]=Math.min(graph[i][k]+graph[k][j],graph[i][j]);
                }
            }
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
        int[][] graph= new int[n][n];
        x=x-1;
        y=y-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j]=105;
                if(i==j)
                {
                    graph[i][j]=0;
                }
                if(i!=0 && j==i-1)
                {
                    graph[i][j]=1;
                }
                if(i!=n-1 && j==i+1)
                {
                    graph[i][j]=1;
                }
                if(i==x && j==y && x!=y)
                {
                    graph[i][j]=1;
                }
                if(i==y && j==x && x!=y)
                {
                    graph[i][j]=1;
                }
            }
        }
        FloydWarshall(graph,n-1);
        int[] arr1= new int[n];
        Arrays.fill(arr1,0);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(graph[i][j]!=0 && graph[i][j]<=n)
                {
                   arr1[graph[i][j]-1]++;
                }
            }
        }
        return arr1;
    }
}