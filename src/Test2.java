import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    static class Node {
        int x, y;
        Node dir;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//    static int[][] Test.map = {
//            {1, 1, 1, 1, 1, 1},
//            {1, 0, 0, 0, 1, 1},
//            {1, 0, 1, 0, 0, 1},
//            {1, 1, 1, 1, 1, 1}
//    };
    static Queue<Node> queue = new LinkedList<>();
    static Node temp;
    public static ArrayList<String> path;
    static void findPathUsingBFS(int sy, int sx, int ey, int ex) {
        boolean[][] visited = new boolean[Test.map.length][Test.map[0].length];
        queue.offer(new Node(sx, sy));
        visited[sx][sy] = true;
        Node newNode;
        while ((temp=queue.poll())!=null) {
            if (temp.x==ex&&temp.y==ey) {
                queue = new LinkedList<>();
                break;
            }
            if (!visited[temp.x][temp.y-1]&&
                    Test.map[temp.x][temp.y-1]!=1&&
                    Test.map[temp.x][temp.y-1]!=4&&
                    Test.map[temp.x][temp.y-1]!=5) {
//                if (temp.x==ex&&temp.y-1==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x, temp.y-1);
                newNode.dir = temp;
                visited[temp.x][temp.y-1] = true;
                queue.offer(newNode);

            }
            if (!visited[temp.x][temp.y+1]&&
                    Test.map[temp.x][temp.y+1]!=1&&
                    Test.map[temp.x][temp.y+1]!=4&&
                    Test.map[temp.x][temp.y+1]!=5) {
//                if (temp.x==ex&&temp.y+1==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x, temp.y+1);
                newNode.dir = temp;
                visited[temp.x][temp.y+1] = true;

                queue.offer(newNode);
            }
            if (!visited[temp.x-1][temp.y]&&
                    Test.map[temp.x-1][temp.y]!=1&&
                    Test.map[temp.x-1][temp.y]!=4&&
                    Test.map[temp.x-1][temp.y]!=5) {
//                if (temp.x-1==ex&&temp.y==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x-1, temp.y);
                newNode.dir = temp;
                visited[temp.x-1][temp.y] = true;

                queue.offer(newNode);

            }
            if (!visited[temp.x+1][temp.y]&&
                    Test.map[temp.x+1][temp.y]!=1&&
                    Test.map[temp.x+1][temp.y]!=4&&
                    Test.map[temp.x+1][temp.y]!=5) {
//                if (temp.x+1==ex&&temp.y==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x+1, temp.y);
                newNode.dir = temp;
                visited[temp.x+1][temp.y] = true;

                queue.offer(newNode);

            }
        }
        path=new ArrayList<>();
        while (temp!=null&&temp.dir!=null) {
            if (temp.dir.x+1==temp.x) {
                path.add("down");
            } else if (temp.dir.y+1==temp.y) {
                path.add("right");
            } else if (temp.dir.x-1==temp.x) {
                path.add("up");
            } else path.add("left");
            temp=temp.dir;
        }
        for (int i=0;i<path.size();i++) {
            System.out.println(path.get(i));
        }
    }

    public static void main(String[] args) {
        findPathUsingBFS(2, 14, 2, 2);
    }

}
