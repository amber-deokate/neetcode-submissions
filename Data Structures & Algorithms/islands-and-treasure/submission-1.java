class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int inf = 2147483647;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dist = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int l = 0; l < 4; l++) {
                    int nr = r + dir[l][0];
                    int nc = c + dir[l][1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == inf) {
                        grid[nr][nc] = dist;
                        q.offer(new int[]{nr, nc});
                        

                    }
                    
                }

            }
            dist++;
        }
    }
}
