class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
        
    }

    void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int idx) {
        int n = nums.length;
        // if (idx == n) {
            res.add(new ArrayList<>(curr));
            // return;
        // }
        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }

    }
}
