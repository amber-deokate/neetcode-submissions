class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        int i = 0, j = n - 1;
        

        while (i <= j) { 
            if (nums[i] < nums[j]) {
                return nums[i];
            }
            

            if (i + 1 == j || i == j) {
                return Math.min(nums[i], nums[j]);
            }
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[i]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return -1;
        
    }
}
