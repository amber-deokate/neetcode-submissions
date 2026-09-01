class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }


        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        f(digits, ans, map,  0, new StringBuilder());

        return ans;
        
    }

    void f(String digits, List<String> ans, Map<Character, String> map, int i, StringBuilder sb) {

        int n = digits.length();
        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }
        char digit = digits.charAt(i);
        String str = map.get(digit);
        for (char c : str.toCharArray()) {
            sb.append(c);
            f(digits, ans, map,  i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
