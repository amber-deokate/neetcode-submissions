class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = n * m - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
        
    }
}
