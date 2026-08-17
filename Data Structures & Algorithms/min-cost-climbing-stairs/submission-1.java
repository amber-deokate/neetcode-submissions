class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int s1 = cost[1], s2 = cost[0];
        if (n == 1) {
            return s2;
        }
        if (n == 2) {
            return Math.min(s1, s2);
        }
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(s1, s2);
            
            s2 = s1;
            s1 = curr;
            if (i == n - 1) {
                return Math.min(s1, s2);
            }
        }return -1;
        
    }
}
