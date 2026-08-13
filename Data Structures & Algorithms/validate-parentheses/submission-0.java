class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (s.isEmpty()) {
                    return false;
                }
                char curr = s.pop();
                if (c == ')') {
                    if (curr != '(') {
                        return false;
                    }
                }if (c == '}') {
                    if (curr != '{') {
                        return false;
                    }
                }if (c == ']') {
                    if (curr != '[') {
                        return false;
                    }
                }

            } else {
                s.push(c);

            }
        }
        return s.isEmpty();
        
    }
}
