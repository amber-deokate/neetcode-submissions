class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] l = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if (l[val] == null) {
                l[val] = new ArrayList<>();
            }
            l[val].add(key);
        }
        int idx = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--) {
            if (l[i] != null) {
                for (int j : l[i]) {
                    res[idx++] = j;
                    if (idx == k) {
                        return res;
                    }
                }
            }
        }
        return res;
        
    }
}
