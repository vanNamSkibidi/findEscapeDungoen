package newProject.test2;

import newProject.entity.MonkeyDemon;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setMonster() {
        gp.monsters[0] = new MonkeyDemon(gp);
//        gp.monsters[1] = new MonkeyDemon(gp);
//        gp.monsters[2] = new MonkeyDemon(gp);
//        gp.monsters[3] = new MonkeyDemon(gp);
//        gp.monsters[4] = new MonkeyDemon(gp);
//        gp.monsters[5] = new MonkeyDemon(gp);
//        gp.monsters[6] = new MonkeyDemon(gp);
//        gp.monsters[7] = new MonkeyDemon(gp);

        gp.monsters[0].worldX = gp.tileSize * 2;//col
        gp.monsters[0].worldY = gp.tileSize * 2;//row
//        gp.monsters[1].worldX = gp.tileSize * 5;
//        gp.monsters[1].worldY = gp.tileSize * 5;
//        gp.monsters[2].worldX = gp.tileSize * 47;
//        gp.monsters[2].worldY = gp.tileSize * 21;
//        gp.monsters[3].worldX = gp.tileSize * 23;
//        gp.monsters[3].worldY = gp.tileSize * 41;
//        gp.monsters[4].worldX = gp.tileSize * 42;
//        gp.monsters[4].worldY = gp.tileSize * 3;
//        gp.monsters[5].worldX = gp.tileSize * 53;
//        gp.monsters[5].worldY = gp.tileSize * 45;
//        gp.monsters[6].worldX = gp.tileSize * 53;
//        gp.monsters[6].worldY = gp.tileSize * 45;
//        gp.monsters[7].worldX = gp.tileSize * 53;
//        gp.monsters[7].worldY = gp.tileSize * 45;
    }
}
