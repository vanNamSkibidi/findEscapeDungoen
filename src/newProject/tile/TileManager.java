package newProject.tile;
import newProject.test2.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    public Tile[] tiles;
    public int[][] map = {
            {1, 1, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 8, 8, 8, 8, 8, 1, 1, 1, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 1, 8, 8, 4, 4, 4, 8, 8, 8, 1, 1, 8, 8, 8, 8, 8, 8, 8, 1, 1, 1, 1, 8, 8, 4, 4, 8, 8, 1},
            {1, 8, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 3, 1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 1},
            {1, 4, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 2, 1, 3, 5, 5, 5, 5, 5, 5, 2, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1},
            {1, 4, 3, 1, 1, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 3, 1, 1, 2, 1, 1, 2, 8, 2, 5, 5, 5, 5, 5, 5, 3, 8, 8, 5, 5, 5, 5, 5, 5, 5, 8, 8, 8, 8, 3, 8, 8, 1, 1, 2, 1},
            {1, 1, 2, 1, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 3, 1, 1, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 8, 8, 3, 1},
            {1, 1, 3, 8, 8, 2, 8, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 5, 5, 5, 5, 5, 5, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 4, 1, 3, 2, 3, 2, 1},
            {1, 1, 2, 3, 2, 3, 4, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 5, 5, 5, 5, 5, 5, 2, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 8, 0, 8, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 2, 3, 2, 2, 2, 3, 2, 3, 2, 2, 3, 2, 2, 3, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 2, 2, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 2, 2, 2, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 2, 1, 1, 1, 2, 1, 1, 8, 2, 8, 8, 8, 8, 8, 2, 8, 8, 2, 8, 8, 8, 1, 1, 1, 1, 1, 8, 8, 8, 8, 8, 8, 3, 1, 1, 1, 1},
            {1, 8, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 1, 1, 1, 3, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 2, 1, 1, 1, 1},
            {1, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 0, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 4, 3, 8, 8, 8, 1, 1, 1, 1, 1, 2, 8, 8, 8, 1, 1, 1, 1, 2, 8, 8, 8, 3, 1, 1, 2, 2, 2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 8, 8, 8, 8, 8, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 1, 1, 1, 1, 1, 3, 2, 2, 3, 1, 1, 1, 1, 3, 2, 3, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 2, 2, 2, 3, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 8, 8, 8, 3, 1, 1, 1, 1, 8, 8, 8, 8, 2, 8, 8, 8, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 8, 8, 8, 3, 8, 8, 8, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 3, 2, 3, 2, 1, 1, 1, 1, 2, 3, 2, 2, 3, 2, 3, 2, 1, 1, 1, 1, 8, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 3, 8, 8, 8, 8, 8, 8, 8, 2, 1, 1, 1, 1, 1, 1, 2, 8, 8, 8, 8, 2, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 3, 1, 1, 1, 1, 1, 3, 8, 8, 8, 8, 8, 2, 1, 1, 1, 1},
            {1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 2, 2, 3, 2, 2, 3, 8, 2, 3, 2, 3, 2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 2, 3, 1, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 2, 8, 8, 8, 1, 1, 1, 1, 3, 8, 8, 8, 8, 8, 8, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 2, 8, 8, 8, 8, 8, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 3, 2, 3, 2, 1, 1, 1, 1, 2, 3, 2, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 5, 5, 5, 5, 5, 1, 1, 2, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 5, 5, 5, 5, 5, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 8, 8, 8, 3, 8, 8, 8, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 5, 5, 5, 5, 5, 1, 1, 3, 8, 8, 8, 8, 1, 8, 8, 8, 3, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 5, 5, 5, 5, 5, 1, 1, 2, 2, 3, 2, 2, 1, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 4, 1, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 2, 1, 1, 3, 1, 1, 1, 1, 8, 3, 1, 1, 1, 1, 1, 3, 1},
            {1, 1, 1, 1, 1, 3, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 3, 8, 8, 2, 1, 1, 1, 1, 4, 2, 1, 8, 0, 8, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 1, 1, 1, 4, 3, 1, 2, 2, 2, 1, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 4, 2, 1, 2, 2, 2, 1, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 8, 8, 3, 8, 8, 8, 3, 1, 1, 1, 1, 1, 8, 8, 8, 8, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 8, 2, 2, 2, 8, 3, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 2, 3, 2, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 8, 8, 8, 4, 4, 4, 8, 8, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 4, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 8, 2, 8, 8, 1, 1},
            {1, 1, 8, 8, 8, 3, 1, 8, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 4, 3, 2, 3, 1, 1},
            {1, 1, 2, 3, 2, 2, 8, 4, 8, 8, 3, 1, 1, 1, 1, 1, 3, 8, 8, 8, 1, 1, 1, 3, 1, 1, 1, 8, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8, 2, 1, 2, 1, 1},
            {1, 1, 2, 1, 1, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 2, 3, 2, 3, 1, 1, 1, 2, 1, 1, 1, 3, 2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 1, 3, 8, 1},
            {1, 1, 3, 8, 8, 8, 8, 2, 1, 1, 3, 1, 1, 1, 1, 1, 3, 4, 4, 2, 1, 1, 1, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 1},
            {1, 1, 2, 3, 2, 3, 2, 3, 1, 1, 2, 8, 8, 8, 8, 8, 2, 1, 1, 3, 8, 8, 8, 2, 8, 8, 8, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 4, 1},
            {1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 3, 2, 3, 2, 3, 2, 3, 1, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 8, 8, 8, 2, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 3, 2, 3, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    Color[] colors;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[10];
//        map = new int[gp.maxWorldRow][gp.maxWorldCol];
        getTileImage();
//        loadMap();
        colors = new Color[10];
        colors[1]=Color.BLACK;
    }
    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[7] = new Tile();
            tiles[1] = new Tile();
            tiles[8] = new Tile();
            tiles[2] = new Tile();
            tiles[3] = new Tile();
            tiles[4] = new Tile();
            tiles[5] = new Tile();
            tiles[6] = new Tile();

            tiles[0].image = ImageIO.read(new File("src/res/tile/6_2.png"));
            tiles[8].image = ImageIO.read(new File("src/res/tile/1_1.png"));
            tiles[2].image = ImageIO.read(new File("src/res/tile/2_3.png"));
            tiles[3].image = ImageIO.read(new File("src/res/tile/3_1.png"));
            tiles[4].image = ImageIO.read(new File("src/res/tile/4_2.png"));
            tiles[5].image = ImageIO.read(new File("src/res/tile/5_1.png"));
            tiles[6].image = ImageIO.read(new File("src/res/tile/6_1.png"));

            tiles[8].collision = true;
            tiles[4].collision = true;
            tiles[5].collision = true;
            tiles[1].collision = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public void loadMap() {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("src/newProject.data/maze.txt"));
//
//            String line;
//            int row = 0;
//            while ((line = br.readLine()) != null) {
//
//                String[] number = line.split("\\s+");
//                for (int i = 0; i < gp.maxWorldCol; i++) {
//                    map[row][i] = Integer.parseInt(number[i]);
//                }
//                row++;
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void draw(Graphics2D g2d) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int worldX = j * gp.tileSize;
                int worldY = i * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;

                if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                        && worldX - gp.tileSize < gp.player.screenX + gp.player.worldX
                        && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                        && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
                {

                    if (map[i][j]==1) {
                        g2d.setColor(colors[map[i][j]]);
                        g2d.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
                    } else g2d.drawImage(tiles[map[i][j]].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }
        }
    }
}
