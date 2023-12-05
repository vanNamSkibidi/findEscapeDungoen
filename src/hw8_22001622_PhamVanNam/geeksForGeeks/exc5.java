package hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class exc5 {
    public boolean Bfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(src);

        while(!q.isEmpty()){
            int idx = q.poll();
            if(visited[idx]){
                return true;
            }
            visited[idx] = true;
            for(int nbr : adj.get(idx)){
                if(!visited[nbr]){
                    q.add(nbr);
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]&&Bfs(adj, i, visited)){
                return true;
            }
        }
        return false;
    }

}
