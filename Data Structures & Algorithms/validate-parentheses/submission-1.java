class Solution {
    public boolean isValid(String str) {
        Deque<Character> s = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                s.push(')');
            } else if (c == '[') {
                s.push(']');
            } else if (c == '{') {
                s.push('}');
            } else if (s.isEmpty() || s.pop() != c) {
                return false;
            }
        }
        return s.isEmpty();

    }
}
