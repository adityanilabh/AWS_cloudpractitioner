import java.util.*;
class Solution994H {
    public void getOranges(int row,int column,int[][]grid,Queue<Pair<Integer,Integer>>indexHai)
    {
        if(row<0 || row>=grid.length || column<0 || column>=grid[0].length|| grid[row][column]==2 || grid[row][column]==0)
        {
            return;
        }
        grid[row][column]=2;
        indexHai.add(new Pair<>(row,column));
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>>indexHai= new LinkedList<>();
        int ifOne=0,ifTwo=0,ifZero=0;
        for(int i=0;i<grid.length;i++)
        {
            
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    ifOne=1;
                }
                else if(grid[i][j]==0)
                {
                    ifZero=1;
                }
                if(grid[i][j]==2)
                {
                    indexHai.add(new Pair<>(i,j));
                }
            }
        }
        if(indexHai.isEmpty())
        {
            if(ifOne==1)
            {
                return -1;
            }
            return 0;
        }
        indexHai.add(new Pair<>(-1,-1));
        int timer=0;
        while(!indexHai.isEmpty())
        {
            Pair<Integer,Integer>indexs= indexHai.remove();
            if(indexs.getValue()==-1 && indexs.getKey()==-1){
                if(indexHai.isEmpty())
                {
                    break;
                }
                else
                {
                    timer++;
                    indexHai.add(new Pair<>(-1,-1));
                }
            }
            // function to store oranges.
            int row=indexs.getKey(),column=indexs.getValue();
            getOranges(row+1,column,grid,indexHai);
            getOranges(row-1,column,grid,indexHai);
            getOranges(row,column+1,grid,indexHai);
            getOranges(row,column-1,grid,indexHai);
        }
        for(int gridEach[]:grid)
        {
            for(int element:gridEach)
            {
                if(element==1)
                {
                    return -1;
                }
            }
        }
        return timer;
    }
}