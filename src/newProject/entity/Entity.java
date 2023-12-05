package newProject.entity;

import newProject.test2.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX;
    public int worldY;
    public int speed;
    public String direction;
    public int spriteCounter =0;
    public int spriteNum = 1;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public Rectangle solidArea = new Rectangle(12, 24,24, 24);
    public boolean collisionOn;
    public int actionLockCounter = 0;
    public boolean onPath = true;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    int screenX, screenY;
    BufferedImage image;
    public void draw(Graphics2D g2, GamePanel gp) {
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.screenX + gp.player.worldX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
        {
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;

            switch (direction) {
                case "up" :
                    if (spriteNum == 1) {
                        image = up1;
                    }else image = up2;
                    break;
                case "down" :
                    if (spriteNum == 1) {
                        image = down1;
                    }else image = down2;
                    break;
                case "left" :
                    if (spriteNum == 1) {
                        image = left1;
                    }else image = left2;
                    break;
                case "right" :
                    if (spriteNum == 1) {
                        image = right1;
                    }else image = right2;
                    break;
            };
            g2.drawImage(image, screenX, screenY, 48, 48, null);
        }
    }
    public void setAction() {

    }
    public void checkCollision() {
        collisionOn = false;
        gp.collisionChecker.checkTile(this);
        //check gameOver;
        if (worldX -24<= gp.player.worldX&&worldX+24>=gp.player.worldX
                &&worldY -24<= gp.player.worldY&&worldY+24>=gp.player.worldY) {
            gp.gameOver=true;
            collisionOn=true;
        }
    }
    public void update(){
        setAction();
        checkCollision();

        if (!collisionOn) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }

        }
        spriteCounter++;
        if (spriteCounter > 200) {
            if (spriteNum == 1) spriteNum = 2;
            else spriteNum = 1;
            spriteCounter = 0;
        }
    }
//    boolean found = true;
    public void searchPath(int goalCol, int goalRow) {
        int startCol = (worldX+ solidArea.x)/gp.tileSize;
        int startRow = (worldY+ solidArea.y)/gp.tileSize;

//        if (found) {
            gp.pathFinder.getPath(startCol, startRow, goalCol, goalRow);
//            found = false;
//        }
        if (!gp.pathFinder.path.isEmpty()) {
            int nextX = gp.pathFinder.path.peek().y * 48;
            int nextY = gp.pathFinder.path.peek().x * 48;

            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY + solidArea.y + solidArea.height;

            if (enLeftX >= nextX && enRightX < nextX + 48) {
                if (enTopY > nextY) {
                    direction = "up";
                } else if (enTopY < nextY) {
                    direction = "down";
                }
            } else if (enTopY >= nextY && enBottomY < nextY + 48) {
                if (enLeftX > nextX) direction = "left";
                else if (enLeftX < nextX) direction = "right";
            } else if (enTopY > nextY && enLeftX > nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn) direction = "left";
            } else if (enTopY > nextY && enLeftX < nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn) direction = "right";
            } else if (enTopY < nextY && enLeftX > nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn) direction = "left";
            } else if (enTopY < nextY && enLeftX < nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn) direction = "right";
            }
        }
//        if (!gp.pathFinder.path.isEmpty()) return;
//        int nextCol=gp.pathFinder.path.peek().y;
//        int nextRow=gp.pathFinder.path.pop().x;
//
//        if (nextCol==goalCol&&nextRow==goalRow) {
//            onPath=false;
//        }
    }
}
