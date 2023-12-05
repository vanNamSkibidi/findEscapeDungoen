package hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;
import java.util.HashSet;

public class exc2 {
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    HashSet<Node> map = new HashSet<>();
    Node cloneGraph(Node node){
        if (node==null) return null;
        map.add(node);
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            if (map.contains(node.neighbors.get(i))) continue;
            list.add(cloneGraph(node.neighbors.get(i)));
        }
        return new Node(node.val, list);
    }
}
