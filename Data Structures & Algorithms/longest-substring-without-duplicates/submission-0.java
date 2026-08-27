class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Integer> hs = new HashSet<>();
        Map<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int i = 0, mx = 0;

        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (!hm.containsKey(c)) {
                hm.put(c, j);
                mx = Math.max(j - i + 1, mx);
            } else {
                while (i < n && s.charAt(i) != c) {
                    hm.remove(s.charAt(i));
                    i++;
                }
                i = i + 1;
                hm.put(c, j);
                mx = Math.max(j - i + 1, mx);
            }


        } return mx;
        
    }
}
