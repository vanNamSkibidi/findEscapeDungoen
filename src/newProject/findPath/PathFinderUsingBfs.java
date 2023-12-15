package newProject.findPath;

import newProject.test2.GamePanel;

public class PathFinderUsingBfs {
    GamePanel gp;
    public class Node {
        public int x;
        public int y;
        public int direction;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 0;
        }
    }
    public PathFinderUsingBfs(GamePanel gp) {
        this.gp = gp;
    }

}
