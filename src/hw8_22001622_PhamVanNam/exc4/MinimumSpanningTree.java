package hw8_22001622_PhamVanNam.exc4;

public class MinimumSpanningTree {
    static class Node {
        boolean visited;
        int prev;
        int distance=Integer.MAX_VALUE;
    }
    public void solution(int[][] map) {
        Node[] nodes = new Node[map.length];
        for (int i = 0; i < map.length; i++) {
            nodes[i] = new Node();
        }
        nodes[0].distance = 0;
        nodes[0].visited=true;
        prim(map, nodes);
        for (int i = 0; i < map.length; i++) {
            System.out.println(i+" have distance : " + nodes[i].distance + " with parent is " + nodes[i].prev);
        }
    }
    boolean check;
    int countCheck=0;
    int min;
    int idxMin;
    int prev;

    public void prim(int[][] map, Node[] nodes) {
        if (countCheck++==map.length-1) check=true;
        if (check) return;

        min = Integer.MAX_VALUE;
        idxMin = -1;
        prev=-1;
        for (int j = 0; j < map.length; j++) {
            if (nodes[j].visited) {
                for (int i = 0; i < map.length; i++) {
                    if (!nodes[i].visited&&map[j][i]!=0&&map[j][i] < min) {
                        min = map[j][i];
                        idxMin = i;
                        prev = j;
                    }
                }
            }
        }
        nodes[idxMin].prev = prev;
        nodes[idxMin].distance = min;
        nodes[idxMin].visited=true;
        prim(map, nodes);
    }
}
