class Solution {
    int mx = 0, curr = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                curr = 0;
                dfs(grid, i, j);
            }
        }
        return mx;
        
    }

    void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        curr++;
        mx = Math.max(mx, curr);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
