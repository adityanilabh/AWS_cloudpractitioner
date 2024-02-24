class Solution695 {
    class DSU {
        int[] parent;
        int[] rank;
        int[] size;
        int maxArea;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            maxArea = 0;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                maxArea = Math.max(maxArea, size[rootY]);
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxArea = Math.max(maxArea, size[rootX]);
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                rank[rootX]++;
                maxArea = Math.max(maxArea, size[rootX]);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        // solving using union find alrogithm
        // the idea is to create a parent array.
        //traverse the graph, and if value is 1, then apply dfs
        int rows= grid.length;
        int cols= grid[0].length;
        DSU dsu= new DSU(rows*cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int isMaxZero=dsu.maxArea;
                    if(isMaxZero==0)
                    {
                        dsu.maxArea=1;
                    }
                    int index = i * cols + j;
                    if (i > 0 && grid[i - 1][j] == 1) dsu.union(index, index - cols); // Merge with top cell
                    if (i < rows - 1 && grid[i + 1][j] == 1) dsu.union(index, index + cols); // Merge with bottom cell
                    if (j > 0 && grid[i][j - 1] == 1) dsu.union(index, index - 1); // Merge with left cell
                    if (j < cols - 1 && grid[i][j + 1] == 1) dsu.union(index, index + 1); // Merge with right cell
                }
            }
        }

        return dsu.maxArea;
    }

}
