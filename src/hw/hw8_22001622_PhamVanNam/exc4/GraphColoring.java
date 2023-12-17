package hw.hw8_22001622_PhamVanNam.exc4;

import java.util.*;

public class GraphColoring {
    Queue<Node> queue = new PriorityQueue<>((a, b)->Integer.compare(b.degree, a.degree));
    static class Node {
        int idx;
        int degree;

        public Node(int idx, int degree) {
            this.idx = idx;
            this.degree = degree;
        }
    }
    int count;
    int[] colored;
    public void solution(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            count=0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j]!=0) count++;
            }
            queue.offer(new Node(i, count));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            list.add(Objects.requireNonNull(queue.poll()).idx);
        }
        colored = new int[map.length];
        int newColor = 1;
        for (int i = 0; i < list.size()-1; i++) {
            if (colored[list.get(i)]==0) {
                colored[list.get(i)] = newColor;
                for (int j = 0; j < list.size(); j++) {
                    if (colored[j]==0&&map[list.get(i)][j]==0) {
                        colored[j] = newColor;
                    }
                }
                newColor++;
            }
        }
        print(colored);
    }
    public void print(int[] colored) {
        int i=0;
        for (int val : colored) {
            System.out.println("idx " + i++ + " have color : " + val);
        }
    }


}
