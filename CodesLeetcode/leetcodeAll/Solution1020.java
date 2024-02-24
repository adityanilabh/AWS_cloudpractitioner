class Solution1020 {
    public void dfs(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0 || visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        dfs(grid, row - 1, column, visited);
        dfs(grid, row + 1, column, visited);
        dfs(grid, row, column - 1, visited);
        dfs(grid, row, column + 1, visited);
    }

    public int numEnclaves(int[][] grid) {
        // solve using dfs
        int sizeOfRow = grid.length;
        int sizeOfColumn = grid[0].length;
        boolean[][] visited = new boolean[sizeOfRow][sizeOfColumn];
        int NumberOfOne = 0;
        for (int i = 0; i < sizeOfRow; i++) {
            for (int j = 0; j < sizeOfColumn; j++) {
                if (grid[i][j] == 1) {
                    NumberOfOne++;
                }
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < sizeOfRow; i++) {
            if (i == 0 || i == sizeOfRow - 1) {
                for (int j = 0; j < sizeOfColumn; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        dfs(grid, i, j, visited);
                    }
                }
            } else {
                if (grid[i][0] == 1 && !visited[i][0]) {
                    dfs(grid, i, 0, visited);
                }
                if (grid[i][sizeOfColumn - 1] == 1 && !visited[i][sizeOfColumn - 1]) {
                    dfs(grid, i, sizeOfColumn - 1, visited);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < sizeOfRow; i++) {
            for (int j = 0; j < sizeOfColumn; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }
}
