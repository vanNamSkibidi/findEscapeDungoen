

import java.util.Stack;

public class Test {
    static int[][] map = {
            {1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
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
    public static Stack<Node> path;

    public static void findPathUsingDfs(int startCol, int startRow, int colTh, int rowTh) {
        visited = new boolean[map.length][map[0].length];
        visited[startRow][startCol] = true;
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
                if (x - 1 > 0 && map[x - 1][y] != 1 && map[x - 1][y] != 4
                        && map[x - 1][y] != 5 && !visited[x - 1][y]) {
                    Node temp1 = new Node(x - 1, y);
                    visited[x - 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 1) {//left
                if (y - 1 > 0 && map[x][y - 1] != 1
                        && map[x][y - 1] != 4 && map[x][y - 1] != 5
                        && !visited[x][y - 1]) {
                    Node temp1 = new Node(x, y - 1);
                    visited[x][y - 1] = true;
                    stack.push(temp1);
                }
            } else if (dir == 2) {//down
                if (x + 1 < map.length && map[x + 1][y] != 1
                        && map[x + 1][y] != 4 && map[x + 1][y] != 5 && !visited[x + 1][y]) {
                    Node temp1 = new Node(x + 1, y);
                    visited[x + 1][y] = true;
                    stack.push(temp1);
                }
            } else if (dir == 3) {//right
                if (y + 1 < map[0].length && map[x][y + 1] != 1
                        && map[x][y + 1] != 4 && map[x][y + 1] != 5 && !visited[x][y + 1]) {
                    Node temp1 = new Node(x, y + 1);
                    visited[x][y + 1] = true;
                    stack.push(temp1);
                }
            } else {
                stack.pop();
            }
        }
    }

    public static void getPath(int startCol, int startRow, int colTh, int rowTh) {
        findPathUsingDfs(startCol, startRow, colTh, rowTh);
        path = new Stack<>();
        while (!stack.isEmpty()) {
            path.push(stack.pop());
        }
        if (!path.isEmpty()) path.pop();
    }

    //
    public static void main(String[] args) {
//        getPath(2, 1, 4, 2);
//        while (!path.isEmpty()) {
//            System.out.println(path.peek().y +" "+ path.pop().x);
//        }
//        Test2 test2 = new Test2();
//        test2.findPathUsingBFS(1, 2, 2,4);
    }
}
