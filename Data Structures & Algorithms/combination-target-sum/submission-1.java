class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, res);
        return new ArrayList<>(res);
        
    } 
    
    void backtrack(int[] nums, int target, int i, List<Integer> curr, int sum,  Set<List<Integer>> res) {
        int n = nums.length;
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= n || sum > target) {
            return;
        }
        backtrack(nums, target, i + 1, curr, sum, res);
        curr.add(nums[i]);
        backtrack(nums, target, i, curr, sum + nums[i], res);
        // backtrack(nums, target, i + 1, curr, sum + nums[i], res);
        curr.remove(curr.size() - 1);
    }
}
