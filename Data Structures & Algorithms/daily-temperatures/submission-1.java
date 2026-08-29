class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<T> s = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        s.push(new T(temperatures[n - 1], n - 1));
        for (int i = n - 2; i >= 0; i--) {
            int curr = temperatures[i];
            while (!s.isEmpty() && s.peek().temp <= curr) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i] = s.peek().idx - i;
            }
            s.push(new T(temperatures[i], i));
        }
        return res;
    }

    class T {
        int temp;
        int idx;

        public T (int temp, int idx) {
            this.temp = temp;
            this.idx = idx;

        }

    }
}
