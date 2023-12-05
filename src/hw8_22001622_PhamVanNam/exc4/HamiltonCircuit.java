package hw8_22001622_PhamVanNam.exc4;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonCircuit {
    public void solution(int[][] map) {
        System.out.println(dfs(map, 0));
    }
    HashSet<Integer> set = new HashSet<>();
    boolean check;
    boolean dfs(int[][] graph, int i) {
        set.add(i);
        if (set.size() == graph.length) {
            if (graph[0][i]!=0) return true;
        }
        for (int idx=0;idx<graph.length;idx++)
            if (graph[i][idx]!=0&&
                !set.contains(idx)&&dfs(graph, idx)) return true;
        set.remove(i);
        return false;
    }
}
