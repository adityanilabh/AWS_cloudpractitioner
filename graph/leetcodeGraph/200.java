class 200 {
    private void dfsOfGrid(boolean[][]visited,int indexRow,int indexColumn,char[][] grid,int row,int column)
    {
        if(indexRow<0 || indexRow>=row || indexColumn<0 || indexColumn>=column || grid[indexRow][indexColumn]=='0' || visited[indexRow][indexColumn]==true)
        {
            return;
        }
        visited[indexRow][indexColumn]=true;
        dfsOfGrid(visited,indexRow+1,indexColumn,grid,row,column);
        dfsOfGrid(visited,indexRow-1,indexColumn,grid,row,column);
        dfsOfGrid(visited,indexRow,indexColumn-1,grid,row,column);
        dfsOfGrid(visited,indexRow,indexColumn+1,grid,row,column);

    }
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int column= grid[0].length;
        boolean[][] visited = new boolean[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                visited[i][j]=false;
            }
        }
        // now traverse the grid, to count number of islands;
        int noOfIsland=0;
        for(int indexRow=0;indexRow<row;indexRow++)
        {
            for(int indexColumn=0;indexColumn<column;indexColumn++)
            {
                if(grid[indexRow][indexColumn]=='0')
                {
                    continue;
                }
                else if(visited[indexRow][indexColumn]==false)
                {
        dfsOfGrid(visited,indexRow,indexColumn,grid,row,column);
                     noOfIsland++;
                }
            }
        }
        return noOfIsland;
    }
}