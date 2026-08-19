class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(new StringBuilder(), n, 0, 0, ans);
        return ans;
    }

    void f(StringBuilder sb, int n, int open, int close, List<String> ans) {
        if (2 * n == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            f(sb, n, open + 1, close, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(')');
            f(sb, n, open, close + 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
