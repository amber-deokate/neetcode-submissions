class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> s = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            s.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !s.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            s.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !s.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (int r = 0; r < 9; r = r + 3) {
            for (int c = 0; c < 9; c = c + 3) {
                s.clear();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] != '.' && !s.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
        
    }
}
