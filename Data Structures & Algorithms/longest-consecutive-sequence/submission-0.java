class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }

        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int ans = 1;

        while (hs.size() != 0) {
            int e = hs.iterator().next();
            hs.remove(e);
            int mx = e;
            int mn = e;
            while (hs.size() != 0 && hs.contains(mx + 1)) {
                mx = mx + 1;
                hs.remove(mx);
            }while (hs.size() != 0 && hs.contains(mn - 1)) {
                mn = mn - 1;
                hs.remove(mn);
            }
            ans = Math.max(ans, mx - mn + 1);

        }return ans;
        
    }
}
