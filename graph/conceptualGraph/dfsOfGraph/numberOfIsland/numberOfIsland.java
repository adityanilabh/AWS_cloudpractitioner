//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        
       if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        boolean[][] visited = new boolean[rows][cols];

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is '1' and not visited, increment island count and explore the island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    exploreIsland(grid, visited, i, j);
                }
            }
        }

        return islandCount;
    }
    
    private void exploreIsland(char[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true; // Mark the current cell as visited

        // Explore adjacent cells (up, down, left, right)
        exploreIsland(grid, visited, row - 1, col); // Up
        exploreIsland(grid, visited, row + 1, col); // Down
        exploreIsland(grid, visited, row, col - 1); // Left
        exploreIsland(grid, visited, row, col + 1); // Right
        exploreIsland(grid,visited,row+1,col+1);
        exploreIsland(grid,visited,row-1,col-1);
        exploreIsland(grid,visited,row-1,col+1);
        exploreIsland(grid,visited,row+1,col-1);
        
    }

}

class numberOfIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


