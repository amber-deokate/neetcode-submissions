class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        dfs(ans, l, n, 0, nums);
        return ans;

        
    }

    void dfs(List<List<Integer>> ans, List<Integer> l, int n, int i, int[] nums) {
        if (i == n) {
            ans.add(new ArrayList<>(l));
            return;
        }
        dfs(ans, l, n, i + 1, nums);
        l.add(nums[i]);
        dfs(ans, l, n, i + 1, nums);
        l.remove(l.size() - 1);

    }
}
