package hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;

public class exc9 {
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        if(V==1)return true;
        for(int i=0;i<V;i++) if(adj.get(i).size()%2!=0) return false;
        return true;
    }
}
