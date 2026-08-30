class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] arr = new int[n][2];

        

        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> s = new Stack<>();


        for (int i = 0; i < n; i++) {

            s.push(( (double) target - arr[i][0]) / arr[i][1]);
            if (s.size() >= 2 && s.peek() <= s.get(s.size() - 2)) {
                s.pop();
            }

        }
        return s.size();
        
    }
}
