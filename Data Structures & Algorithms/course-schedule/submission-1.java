class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int[] p : prerequisites) {
            hm.putIfAbsent(p[0], new ArrayList<>());
            hm.get(p[0]).add(p[1]);
        }
        int n = numCourses;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (!isCompletable(hm, res, i)) {
                return false;

            }
        }
        return true;
        
    }

    boolean isCompletable(Map<Integer, List<Integer>> hm, int[] res, int i) {
        if (res[i] == 1) {
            return false;
        }
        if (res[i] == 2) {
            return true;
        }
        res[i] = 1;
        if (hm.get(i) == null) {
            res[i] = 2;
            return true;
        }


        for(int j : hm.get(i)) {
            if (!isCompletable(hm, res, j)) {
                return false;
            }

        }
        res[i] = 2;
        return true;


    }
}
