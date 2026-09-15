class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1, x = nums[0]; i < nums.length; i++) {
            x = x ^ nums[i];
            if (i == nums.length - 1)return x;
        }
        return nums[0];
        
    }
}
