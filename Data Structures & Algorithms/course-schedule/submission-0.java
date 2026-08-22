
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];
            graph.get(course).add(requiredCourse);
        }

        // 0 = unvisited, 1 = visiting, 2 = completed
        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) return false; // cycle
        if (state[course] == 2) return true;  // already verified

        state[course] = 1;

        for (int prerequisite : graph.get(course)) {
            if (!dfs(prerequisite, graph, state)) {
                return false;
            }
        }

        state[course] = 2;
        return true;
    }
}