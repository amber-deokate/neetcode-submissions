class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<T> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(new T(heights[i], i));
            } else {
                int idx = -1;
                int val = -1;
                boolean flag = false;
                while (!s.isEmpty()) {
                    T top = s.peek();
                    val = top.val;
                    if (val >= heights[i]) {
                        idx = top.idx;
                        s.pop();
                        ans = Math.max(ans, (i - idx) * val);
                        flag = true;
                    } else {
                        break;
                    }
                }
                s.push(new T(heights[i], flag ? idx : i));
            }

        }
        
        while (!s.isEmpty()) {
            T curr = s.pop();
            int idx = curr.idx;
            int val = curr.val;
            ans = Math.max(ans, (n - idx) * val);
        }
        return ans;
        
    }
    class T {
        int val;
        int idx;

        public T(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        public T() {
        }
    }
}
