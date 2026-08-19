class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        if (n == 1) {
            return piles[0] % h == 0 ? piles[0] / h : piles[0] / h + 1;
        }
        int mx = Integer.MIN_VALUE;
        for (int pile : piles) {
            mx = Math.max(mx, pile);
        }



        int l = 1, r = mx;
        while (l + 1 <= r) {
            int mid = l + (r - l) / 2;
            int hrs = 0;
            for (int pile : piles) {
                hrs += pile % mid == 0 ? pile / mid : pile / mid + 1;
            }
            if (hrs > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
            if (l + 1 == r) {
                int mn = 0;
                for (int pile : piles) {
                    mn += pile % l == 0 ? pile / l : pile / l + 1;
                }
                if (mn <= h) {
                    return l;
                }
                return r;

            } 
            if (l == r) {
                return l;
            }
        }
        return -1;

        
    }
}
