

import java.util.Stack;

public class Test {
    static int[][] map = {
            {1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };
//    static class Cell {
//        int x, y, dist;
//        Cell parent;
//
//        public Cell(int x, int y, int dist, Cell parent) {
//            this.x = x;
//            this.y = y;
//            this.dist = dist;
//            this.parent = parent;
//        }
//
//        @Override
//        public String toString() {
//            return x + " " + y;
//        }
//    }
//    static void findPath() {
//        int sx = 1;
//        int sy = 1;
//        int dx = 8;
//        int dy = 11;
//        if (matrix[sx][sy] == 1||matrix[dx][dy]==1) return;
//        Cell[][] cell = new Cell[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j]!=1) {
//                    cell[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
//                }
//            }
//        }
//        LinkedList<Cell> queue = new LinkedList();
//        Cell src = cell[sx][sy];
//        src.dist = 0;
//        queue.offer(src);
//        Cell dest = null;
//        Cell p;
//        while ((p = queue.poll()) != null) {
//            if (p.x == dx && p.y == dy) {
//                dest = p; break;
//            }
//
//            visit(cell, queue, p.x - 1, p.y, p);
//            visit(cell, queue, p.x + 1, p.y, p);
//            visit(cell, queue, p.x, p.y - 1, p);
//            visit(cell, queue, p.x, p.y  + 1, p);
//        }
//        if (dest==null) return;
//        else {
//            LinkedList<Cell> path= new LinkedList<>();
//            p = dest;
//            do {
//                path.addFirst(p);
//            } while ((p = p.parent) != null);
//            System.out.println(path);
//        }
//    }
//    public static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
//        if (x < 0 || y < 0 || y >= cells[0].length|| x >= cells.length||cells[x][y]==null) return;
//        int dist = parent.dist + 1;
//        Cell p = cells[x][y];
//        if (dist < p.dist) {
//            p.dist = dist;
//            p.parent = parent;
//            queue.add(p);
//        }
//    }

    //    static public List<List<Integer>> allPathsSourceTarget() {
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<List<Integer>> q = new LinkedList<>();
//        List<Integer> currList = new ArrayList<>();
//        currList.add(0);
//        q.add(currList);
//        while (!q.isEmpty()) {
//            currList = q.poll();
//            int v = currList.get(currList.size() - 1);
//            if (v == matrix.length - 1) {
//                ans.add(currList);
//                continue;
//            }
//            for (int i : matrix[v]) {
//                List<Integer> temp = new ArrayList<>(currList);
//                temp.add(i);
//                q.add(temp);
//            }
//        }
//        return ans;
//    }
//
//    public static void print(List<List<Integer>> a) {
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j < a.get(i).size(); j++) {
//                System.out.print(a.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//    }
//
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
        getPath(2, 1, 4, 2);
        while (!path.isEmpty()) {
            System.out.println(path.peek().y +" "+ path.pop().x);
        }
    }
}
