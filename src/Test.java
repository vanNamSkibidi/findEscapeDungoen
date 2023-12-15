
import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 3, 1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 1},
            {1, 4, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 2, 1, 3, 5, 5, 5, 5, 5, 5, 2, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1},
            {1, 4, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 2, 1, 2, 5, 5, 5, 5, 5, 5, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1},
            {1, 1, 2, 1, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 3, 1, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 1, 1, 3, 1},
            {1, 1, 3, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 5, 5, 5, 5, 5, 5, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 4, 1, 3, 2, 3, 2, 1},
            {1, 1, 2, 3, 2, 3, 4, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 5, 5, 5, 5, 5, 5, 2, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 2, 3, 2, 2, 2, 3, 2, 3, 2, 2, 3, 2, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 2, 2, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 2, 2, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 1, 1, 1, 3, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 2, 1, 1, 1, 1},
            {1, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 6, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 4, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 2, 2, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 1, 1, 1, 1, 1, 3, 2, 2, 3, 1, 1, 1, 1, 3, 2, 3, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 2, 2, 2, 3, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 3, 2, 3, 2, 1, 1, 1, 1, 2, 3, 2, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 2, 2, 3, 2, 2, 3, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 2, 3, 1, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 3, 2, 3, 2, 1, 1, 1, 1, 2, 3, 2, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 2, 2, 1, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 4, 1, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 2, 1, 1, 1, 1, 4, 2, 1, 1, 0, 1, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 4, 3, 1, 2, 2, 2, 1, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 4, 2, 1, 2, 2, 2, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 2, 2, 2, 1, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 4, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 4, 3, 2, 3, 1, 1},
            {1, 1, 2, 3, 2, 2, 1, 4, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1},
            {1, 1, 2, 1, 1, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 1, 1, 1, 2, 1, 1, 1, 3, 2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 3, 1, 1},
            {1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 1},
            {1, 1, 2, 3, 2, 3, 2, 3, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 4, 1},
            {1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    public static class Node {
        public int x;
        public int y;
        int direction;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 0;
        }
    }

    static Stack<Node> stack = new Stack<>();
    static boolean[][] visited;
    public static ArrayList<String> path;
    public static void findPathUsingDfs(int startCol, int startRow, int colTh, int rowTh) {
        visited = new boolean[map.length][map[0].length];
        visited[startRow][startCol]=true;
        stack.push(new Node(startRow, startCol));
        Node temp;
        int x;
        int y;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            x = temp.x;
            y = temp.y;
            int dir = temp.direction;
            temp.direction += 1;
            stack.push(temp);
//            if (x == gp.player.worldX/48 && y == gp.player.worldY/48) {
//                return;
//            }
            if (x == rowTh && y == colTh) {
                return;
            }
            if (dir == 0) {//up
                if (x - 1 > 0 && map[x - 1][y] != 1 && map[x-1][y] != 4
                        && map[x-1][y] != 5&& !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    stack.push(new Node(x-1, y));
                }
            } else if (dir == 1) {//left
                if (y - 1 > 0 && map[x][y - 1] != 1
                        && map[x][y - 1] != 4&& map[x][y - 1] != 5
                        && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    stack.push(new Node(x, y-1));
                }
            } else if (dir == 2) {//down
                if (x + 1 < map.length && map[x + 1][y] != 1
                        && map[x + 1][y] != 4&& map[x + 1][y] != 5 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    stack.push(new Node(x+1, y));
                }
            } else if (dir == 3) {//right
                if (y + 1 < map[0].length && map[x][y + 1] != 1
                        && map[x][y + 1] != 4&& map[x][y + 1] != 5 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    stack.push(new Node(x, y+1));
                }
            } else {
                stack.pop();
            }
        }
    }

    public static void getPath(int startCol, int startRow, int colTh, int rowTh) {
        findPathUsingDfs(startCol, startRow, colTh, rowTh);

//            gp.keyH.moved=false;
        path = new ArrayList<>();
        while (!stack.isEmpty()) {
            switch (stack.pop().direction - 1) {
                case 0 -> path.add("up");
                case 1 -> path.add("left");
                case 2 -> path.add("down");
                case 3 -> path.add("right");
            }
        }
    }

    //
    public static void main(String[] args) {
//        getPath(2, 14, 2, 1);
//        for (int i = path.size()-2; i >0 ; i--) {
//            System.out.println(path.get(i));
//        }
//        while (!path.isEmpty()) {
//            System.out.println(path.peek().y +" "+ path.pop().x);
//        }
        Test2 test2 = new Test2();
        test2.getPath(1, 2, 2,4);
    }
//    public static void main(String[] args) {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//    }
}
