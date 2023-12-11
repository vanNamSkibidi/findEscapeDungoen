package newProject.entity;

import newProject.test2.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
    int idx=1;
    ArrayList<String> dir= new ArrayList<>();
//    {"up", "up","up","right","down","down","down","right","right","up","up","up","up","up","up","up","up","up","right","up","up","up","up","left","left","left","left"}

    @Override
    public void setAction() {
        if (dir.size()==0) {
            gp.pathFinder.getPath((worldX+ solidArea.x) / 48, (worldY+ solidArea.y) / 48, 2, 1);
            for (int i = gp.pathFinder.path.size()-2; i >=0 ; i--) {
                dir.add(gp.pathFinder.path.get(i));
            }
        }
        if (idx < dir.size()) {
            if (actionLockCounter == 0) {
                direction = dir.get(idx++);
            }
            if (++actionLockCounter == 48) {
                actionLockCounter = 0;
            }
        } else {
            actionLockCounter++;
            if (actionLockCounter==200) {
                Random ra = new Random();
                int val = ra.nextInt(200);
                if (val < 50) {
                    direction = "up";
                } else if (val < 100) {
                    direction = "down";
                } else if (val < 150) {
                    direction = "left";
                } else if (val < 200) {
                    direction = "right";
                }
                actionLockCounter=0;
            }
        }
//        if (!onPath) {
//            int eCol = 2;
//            int eRow = 1;
//            searchPath(eCol, eRow);
//            onPath = true;
//            if (!gp.pathFinder.path.isEmpty()) gp.pathFinder.path.remove(gp.pathFinder.path.size()-1);
//            switch (gp.pathFinder.path.get(gp.pathFinder.path.size() - 1) - 1) {
//                case 0 -> direction = "up";
//                case 1 -> direction = "left";
//                case 2 -> direction = "down";
//                case 3 -> direction = "right";
//            }
//        }
//        actionLockCounter++;
//        if (actionLockCounter == 4) {
//            actionLockCounter = 0;
//            if (!gp.pathFinder.path.isEmpty()) {
//                if (worldY == 2 && worldX == 1) onPath = true;
//                else gp.pathFinder.path.remove(gp.pathFinder.path.size()-1);
//            }
//        }

    }
}
