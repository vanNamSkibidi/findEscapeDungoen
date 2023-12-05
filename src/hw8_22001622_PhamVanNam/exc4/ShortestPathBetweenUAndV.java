package hw8_22001622_PhamVanNam.exc4;

public class ShortestPathBetweenUAndV {
    static class Node {
        int shortestDist=Integer.MAX_VALUE;
        int prev;
    }
    public void solution(int[][] map, int start, int e) {
        //initialize
        boolean[] visited = new boolean[map.length];
        Node[] nodes = new Node[map.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        nodes[start].shortestDist=0;

        //solution
        dijkstras(nodes, visited, map, start);

        //print
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        int idx  = e;
        while (idx!=start) {
            stringBuilder.append(" >- ").append(nodes[idx].prev);
            idx = nodes[idx].prev;
        }
        System.out.println(stringBuilder.reverse());
    }
    int min;
    public void dijkstras(Node[] nodes, boolean[] v, int[][] map, int idxCurr) {
        for (int i = 0; i < map[idxCurr].length; i++) {
            if (!v[i]&&map[idxCurr][i]!=0&&nodes[idxCurr].shortestDist+map[idxCurr][i] < nodes[i].shortestDist) {
                nodes[i].shortestDist = nodes[idxCurr].shortestDist+map[idxCurr][i];
                nodes[i].prev = idxCurr;
            }
        }
        v[idxCurr] = true;
        //reset and find min next shortest distance
        min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            if (!v[i]&&min > nodes[i].shortestDist) {
                min=nodes[i].shortestDist;
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].shortestDist==min) {
                dijkstras(nodes, v, map, i);
                break;
            }
        }
    }
}
