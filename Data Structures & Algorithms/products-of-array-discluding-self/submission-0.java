class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1, cnt = 0, idx = -1;
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 0) {
                cnt++;
                idx = i;
            } else {
                p = p * nums[i];
            }
        }

        if (cnt > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }

        if (cnt == 1) {
            Arrays.fill(nums, 0);
            nums[idx] = p;
            return nums;
        }

        for (int i = 0; i < nums.length; i++) { 
            nums[i] = p / nums[i];
        }
        return nums;
    }
}  
