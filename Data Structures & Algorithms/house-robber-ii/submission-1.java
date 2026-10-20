class Solution {
    public int rob(int[] nums) {
        int ans1 = 0, ans2 = 0, n = nums.length;
        int curr1 = 0, prev1 = 0, curr2 = 0, prev2 = 0; 
        if (n == 1) return nums[0];
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (i != 0) {
                ans1 = Math.max(ans1, prev1 + num);
                prev1 = curr1;
                curr1 = ans1;
            }
            if (i != n - 1) {
                ans2 = Math.max(ans2, prev2 + num);
                prev2 = curr2;
                curr2 = ans2;
            }
        }

        return Math.max(ans1, ans2);




        
    }
}
