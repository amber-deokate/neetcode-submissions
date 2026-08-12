class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        int mn = prices[0];
        for (int i = 1; i < prices.length; i++) {
            p = Math.max(p, prices[i] - mn);
            mn = Math.min(mn, prices[i]);
        }
        return p;
    }
}
