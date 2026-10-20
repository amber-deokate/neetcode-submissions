class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean v[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int idx, boolean v[][]) {
        int sz = word.length();
        int n = board.length, m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || idx >= sz || board[i][j] != word.charAt(idx) || v[i][j]) {
            return false;
        }
        if (idx == sz - 1) {
            return true;
        }
        v[i][j] = true;
        boolean res = false;
        res = res || 
        dfs(board, word, i + 1, j, idx + 1, v) ||
        dfs(board, word, i, j + 1, idx + 1, v) ||
        dfs(board, word, i - 1, j, idx + 1, v) ||
        dfs(board, word, i, j - 1, idx + 1, v);
        v[i][j] = false;
        return res;

        
    }
}
