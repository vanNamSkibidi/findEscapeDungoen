package hw.hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class exc1 {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }

        return lists;
    }
}
