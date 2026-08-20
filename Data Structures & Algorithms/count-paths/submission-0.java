class Solution {
    public int uniquePaths(int m, int n) {

        int[][] arr = new int[m][n];
        return f(arr, m - 1, n - 1);
        
    }

    int f(int[][] arr, int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        } 
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        int ans = f(arr, i - 1, j) + f(arr, i, j - 1);
        arr[i][j] = ans;
        return ans;
    }
}
