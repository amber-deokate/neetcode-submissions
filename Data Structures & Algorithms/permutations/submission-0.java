class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int v[] = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, v, 0, new ArrayList<>(), ans);
        return ans;
        
    }


    void f(int[] nums, int[] v, int idx, List<Integer> curr, List<List<Integer>> ans) {
        int n = nums.length;
        if (idx == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (v[i] == 1) {
                continue;
            }
            v[i] = 1;
            curr.add(nums[i]);
            f(nums, v, idx + 1, curr, ans);
            v[i] = 0;
            curr.remove(curr.size() - 1);

        }


    }
}
