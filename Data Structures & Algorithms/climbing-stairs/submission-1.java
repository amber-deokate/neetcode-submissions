class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int nminus1 = 2, nminus2 = 1;
        for (int i = 3; i <= n; i++) {
            int curr = nminus2 + nminus1;
            if (i == n) {
                return curr;
            }
            nminus2 = nminus1;
            nminus1 = curr;
        }
        return -1;
    }
}
