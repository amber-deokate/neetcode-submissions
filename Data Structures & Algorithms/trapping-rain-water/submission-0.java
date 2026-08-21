class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] l = new int[n];
        int mx = height[0];
        for (int i = 1; i < n - 1; i++) {
            l[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        int[] r = new int[n];
        mx = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            r[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            int curr = Math.min(l[i], r[i]) - height[i];
            ans += curr > 0 ? curr : 0;
        }
        return ans;

        
    }
}
