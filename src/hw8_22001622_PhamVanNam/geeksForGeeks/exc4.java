package hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class exc4 {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.offer(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!visited[curr]) {
                list.add(curr);
                visited[curr] = true;
                for (int i = 0; i < adj.get(curr).size(); i++) {
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        return list;
    }
}
