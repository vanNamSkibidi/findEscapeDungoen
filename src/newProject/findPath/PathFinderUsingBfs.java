package newProject.findPath;

import newProject.test2.GamePanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinderUsingBfs {
    GamePanel gp;

    public PathFinderUsingBfs(GamePanel gp) {
        this.gp = gp;
    }
    public static class Node {
        public int x;
        public int y;
        public Node dir;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Node> queue = new LinkedList<>();
    static Node temp;
    public static ArrayList<String> path;
    public void findPathUsingBFS(int sy, int sx, int ey, int ex) {
        boolean[][] visited = new boolean[gp.tileManager.map.length][gp.tileManager.map[0].length];
        queue.offer(new Node(sx, sy));
        visited[sx][sy] = true;
        Node newNode;
        while ((temp=queue.poll())!=null) {
            if (temp.x==ex&&temp.y==ey) {
                queue = new LinkedList<>();
                break;
            }
            if (!visited[temp.x][temp.y-1]&&
                    gp.tileManager.map[temp.x][temp.y-1]!=1&&
                    gp.tileManager.map[temp.x][temp.y-1]!=4&&
                    gp.tileManager.map[temp.x][temp.y-1]!=5&&
                    gp.tileManager.map[temp.x][temp.y-1]!=8) {
//                if (temp.x==ex&&temp.y-1==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x, temp.y - 1);
                newNode.dir = temp;
                visited[temp.x][temp.y-1] = true;
                queue.offer(newNode);

            }
            if (!visited[temp.x][temp.y+1]&&
                    gp.tileManager.map[temp.x][temp.y+1]!=1&&
                    gp.tileManager.map[temp.x][temp.y+1]!=4&&
                    gp.tileManager.map[temp.x][temp.y+1]!=5&&
                    gp.tileManager.map[temp.x][temp.y+1]!=8) {
//                if (temp.x==ex&&temp.y+1==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x, temp.y + 1);
                newNode.dir = temp;
                visited[temp.x][temp.y+1] = true;

                queue.offer(newNode);
            }
            if (!visited[temp.x-1][temp.y]&&
                    gp.tileManager.map[temp.x-1][temp.y]!=1&&
                    gp.tileManager.map[temp.x-1][temp.y]!=4&&
                    gp.tileManager.map[temp.x-1][temp.y]!=5&&
                    gp.tileManager.map[temp.x-1][temp.y]!=8) {
//                if (temp.x-1==ex&&temp.y==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x - 1, temp.y);
                newNode.dir = temp;
                visited[temp.x-1][temp.y] = true;

                queue.offer(newNode);

            }
            if (!visited[temp.x+1][temp.y]&&
                    gp.tileManager.map[temp.x+1][temp.y]!=1&&
                    gp.tileManager.map[temp.x+1][temp.y]!=4&&
                    gp.tileManager.map[temp.x+1][temp.y]!=5&&
                    gp.tileManager.map[temp.x+1][temp.y]!=8) {
//                if (temp.x+1==ex&&temp.y==ey) {
//                    queue = new LinkedList<>();
//                    break;
//                }
                newNode = new Node(temp.x + 1, temp.y);
                newNode.dir = temp;
                visited[temp.x+1][temp.y] = true;

                queue.offer(newNode);

            }
        }
        queue = new LinkedList<>();
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
//        for (int i=0;i<path.size();i++) {
//            System.out.println(path.get(i));
//        }
    }

}