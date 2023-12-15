package newProject.entity;
import newProject.findPath.PathFinderUsingBfs;
import newProject.test2.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MonkeyDemon extends Entity {
    public MonkeyDemon(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 4;
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(new File("src/res/monster/left1.png"));
            up2 = ImageIO.read(new File("src/res/monster/left2.png"));
            down1 = ImageIO.read(new File("src/res/monster/down1.png"));
            down2 = ImageIO.read(new File("src/res/monster/down2.png"));
            left1 = ImageIO.read(new File("src/res/monster/left1.png"));
            left2 = ImageIO.read(new File("src/res/monster/left2.png"));
            right1 = ImageIO.read(new File("src/res/monster/right1.png"));
            right2 = ImageIO.read(new File("src/res/monster/right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> dir;
    int idx = 0;
//    int resetPath=0;
    boolean onPath = false;


    @Override
    public void setAction() {

//        if (resetPath++==0) {
//            gp.pathFinder.getPath((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48
//                    , (gp.player.worldX+ solidArea.x)/48, (gp.player.worldY+ solidArea.y)/48);
//            dir = new ArrayList<>();
//            for (int i = gp.pathFinder.path.size() - 1; i >= 1; i--) {
//                dir.add(gp.pathFinder.path.get(i));
//            }
//        }
//        if (resetPath==240) {
//            resetPath=0;
//        }
        if (!onPath) {
            if (gp.DifficultLevel.equals("balanced")) {
                gp.pathFinderUsingDfs.getPath((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48
                        , (gp.player.worldX + solidArea.x) / 48, (gp.player.worldY + solidArea.y) / 48);
                dir = new ArrayList<>();
                for (int i = gp.pathFinderUsingDfs.path.size() - 1; i >= 1; i--) {
                    dir.add(gp.pathFinderUsingDfs.path.get(i));
                }
            } else {
                gp.pathFinderUsingBfs.findPathUsingBFS((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48
                        , (gp.player.worldX + solidArea.x) / 48, (gp.player.worldY + solidArea.y) / 48);
                dir = new ArrayList<>();
                for (int i = PathFinderUsingBfs.path.size() - 1; i >= 0; i--) {
                    dir.add(PathFinderUsingBfs.path.get(i));
                }
            }
            onPath=true;
        }

        if (gp.keyH.moved) {
            if (gp.DifficultLevel.equals("balanced")) {
                gp.pathFinderUsingDfs.getPath((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48
                        , (gp.player.worldX + solidArea.x) / 48, (gp.player.worldY + solidArea.y) / 48);
                dir.clear();
                for (int i = gp.pathFinderUsingDfs.path.size() - 1; i >= 1; i--) {
                    dir.add(gp.pathFinderUsingDfs.path.get(i));
                }
            } else {
                gp.pathFinderUsingBfs.findPathUsingBFS((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48
                        , (gp.player.worldX + solidArea.x) / 48, (gp.player.worldY + solidArea.y) / 48);
                dir.clear();
                for (int i = PathFinderUsingBfs.path.size() - 1; i >= 0; i--) {
                    dir.add(PathFinderUsingBfs.path.get(i));
                }
            }
            gp.keyH.moved=false;
            idx=0;
        }
        if (idx < dir.size()) {
            if (actionLockCounter == 0) {
                direction = dir.get(idx++);
            }
            if (++actionLockCounter == 48/speed) {
                actionLockCounter = 0;
            }
        }
//        else {
//            actionLockCounter++;
//            if (actionLockCounter == 200) {
//                Random random = new Random();
//                int i = random.nextInt(200);
//                if (i <= 50) {
//                    direction = "up";
//                } else if (i <= 100) {
//                    direction = "down";
//                } else if (i <= 150) {
//                    direction = "left";
//                } else {
//                    direction = "right";
//                }
//                actionLockCounter = 0;
//            }
//        }
    }
}
