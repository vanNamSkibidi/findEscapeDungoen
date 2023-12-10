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

        gp.monsters[0].worldX = gp.tileSize * 2;
        gp.monsters[0].worldY = gp.tileSize * 14;
//        gp.monsters[1].worldX = gp.tileSize * 53;
//        gp.monsters[1].worldY = gp.tileSize * 45;
//        gp.monsters[2].worldX = gp.tileSize * 1;
//        gp.monsters[2].worldY = gp.tileSize * 11;
    }
}
