package hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;

public class exc3 {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, visited, ans);
        return ans;
    }

    public static void dfs(int idx, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[idx] = true;
        ans.add(idx);
        for (int i : adj.get(idx)) {
            if (!visited[idx]) {
                dfs(i, adj, visited, ans);
            }
        }
    }
}
