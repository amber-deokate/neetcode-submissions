    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            f(res, new ArrayList<>(), 0, s);
            return res;

            
        }

        void f(List<List<String>> res, List<String> curr, int idx, String s) {
            int n = s.length();
            if (idx == n) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int j = idx + 1; j <= n; j++) {
                String str = s.substring(idx, j);
                if (isP(s, idx, j - 1)) {
                    curr.add(str);
                    f(res, curr, j, s);
                    curr.remove(curr.size() - 1);
                }
            }

        }


        boolean isP(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
    }
