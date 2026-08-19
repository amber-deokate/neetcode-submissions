class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(new StringBuilder(), n, 0, ans);
        return ans;
    }

    void f(StringBuilder sb, int n, int diff, List<String> ans) {
        if (2 * n == sb.length()) {
            if (diff == 0) ans.add(sb.toString());
            return;
        }
        sb.append("(");
        f(sb, n, diff + 1, ans);
        sb.deleteCharAt(sb.length() - 1);
        if (diff > 0) {
            sb.append(")");
            f(sb, n, diff - 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
