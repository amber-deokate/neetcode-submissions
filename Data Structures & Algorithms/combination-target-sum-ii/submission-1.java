class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }
    
    void backtrack(int[] nums, int remain, int start, List<Integer> curr,  List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > remain) {
                break;
            }
            curr.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
