package hw.hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;
import java.util.HashSet;

public class exc11 {
    HashSet<Integer> set = new HashSet<>();
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> list : Edges) {
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));

        }
        for (int i = 1; i <= N; i++) {
            if (dfs(graph, N, i)) return true;
        }
        return false;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> graph, int n, int i) {
        set.add(i);
        if (set.size() == n) return true;
        for (int neighbor : graph.get(i)) if (!set.contains(neighbor)&&dfs(graph, n, neighbor)) return true;
        set.remove(i);
        return false;
    }
}
