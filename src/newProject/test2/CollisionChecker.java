package newProject.test2;

import newProject.entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityTopRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityLeftCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityRightCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }
//    public int checkEntity(Entity entity, Entity[] target) {
//        int idx = 999;
//        for (int i = 0; i < target.length; i++) {
//            if (target[i] != null) {
//                entity.solidArea.x = entity.worldX + entity.solidArea.x;
//                entity.solidArea.y = entity.worldX + entity.solidArea.y;
//
//                //get player's solidArea position
//                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
//                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
//
//                switch (entity.direction) {
//                    case "up" -> {
//                        entity.solidArea.y -= entity.speed;
//                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
//
//                            idx=i;
//                        }
//                    }
//                    case "down" -> {
//                        entity.solidArea.y += entity.speed;
//                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
//
//                            idx=i;
//                        }
//                    }
//                    case "left" -> {
//                        entity.solidArea.x -= entity.speed;
//                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                  idx=i;
//                            gp.gameOver = true;
//                        }
//                    }
//                    case "right" -> {
//                        entity.solidArea.x += entity.speed;
//                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
//                     idx=i;
//                        }
//                    }
//                }
//                entity.solidArea.x = 20;
//                entity.solidArea.y = 20;
//                target[i].solidArea.x= 20;
//                target[i].solidArea.y=20;
//            }
//        }
//return idx;
//    }
//    public void checkPlayer(Entity entity) {
//        //get entity's solidArea position
//        entity.solidArea.x = entity.worldX + entity.solidArea.x;
//        entity.solidArea.y = entity.worldX + entity.solidArea.y;
//
//        //get player's solidArea position
//        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
//        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
//
//        switch (entity.direction) {
//            case "up" -> {
//                entity.solidArea.y -= entity.speed;
//                if (entity.solidArea.intersects(gp.player.solidArea)) {
//                    entity.collisionOn = true;
//                    gp.gameOver = true;
//                }
//            }
//            case "down" -> {
//                entity.solidArea.y += entity.speed;
//                if (entity.solidArea.intersects(gp.player.solidArea)) {
//                    entity.collisionOn = true;
//                    gp.gameOver = true;
//                }
//            }
//            case "left" -> {
//                entity.solidArea.x -= entity.speed;
//                if (entity.solidArea.intersects(gp.player.solidArea)) {
//                    entity.collisionOn = true;
//                    gp.gameOver = true;
//                }
//            }
//            case "right" -> {
//                entity.solidArea.x += entity.speed;
//                if (entity.solidArea.intersects(gp.player.solidArea)) {
//                    entity.collisionOn = true;
//                    gp.gameOver = true;
//                }
//            }
//        }
//        entity.solidArea.x = 20;
//        entity.solidArea.y = 20;
//        gp.player.solidArea.x= 20;
//        gp.player.solidArea.y=20;
//
//    }
}
