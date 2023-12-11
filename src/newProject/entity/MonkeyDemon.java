package newProject.entity;

import newProject.findPath.PathFinder;
import newProject.test2.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MonkeyDemon extends Entity {
    public MonkeyDemon(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
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
    @Override
    public void setAction() {
        if (!onPath) {
            int eCol = 2;
            int eRow = 1;
            searchPath(eCol, eRow);
            onPath = true;
            gp.pathFinder.path.pop(); // Clear the path after each action
        }
        // Update direction based on the next step in the path
        if (!gp.pathFinder.path.isEmpty()) {
            PathFinder.Node nextStep = gp.pathFinder.path.peek();
            if (worldX / 48 < nextStep.y) direction = "right";
            else if (worldX / 48 > nextStep.y) direction = "left";
            else if (worldY / 48 > nextStep.x) direction = "up";
            else if (worldY / 48 < nextStep.x) direction = "down";
        }

    }

//    @Override
//    public void setAction() {
//        actionLockCounter++;
//        if (!onPath) {
//            int eCol = 2;
//            int eRow = 1;
//            if (actionLockCounter==48) {
//                searchPath(eCol, eRow);
////            onPath = true;
//                gp.pathFinder.path.pop();
//                actionLockCounter=0;
//            }
//        }
////        else {
////            actionLockCounter++;
////            if (actionLockCounter == 120) {
////                Random random = new Random();
////                int i = random.nextInt(200);
////                if (i <= 50) {
////                    direction = "up";
////                } else if (i <= 100) {
////                    direction = "down";
////                } else if (i <= 150) {
////                    direction = "left";
////                } else {
////                    direction = "right";
////                }
////
////                actionLockCounter = 0;
////            }
////        }
//    }
}
