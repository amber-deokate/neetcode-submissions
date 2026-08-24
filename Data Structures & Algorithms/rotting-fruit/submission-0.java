class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty() && fresh > 0) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int[] cor = q.poll();
                int r = cor[0], c = cor[1];
                for (int j = 0; j < 4; j++) {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }

                }
            }minutes++;
        }
        return fresh == 0 ? minutes : -1;
        
    }
}
