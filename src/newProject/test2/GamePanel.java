package newProject.test2;

import newProject.entity.Entity;
import newProject.entity.Player;
import newProject.findPath.PathFinderUsingBfs;
import newProject.findPath.PathFinderUsingDfs;
import newProject.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;
//    public final int maxWorldCol = 47;
//    public final int maxWorldRow = 56;
//    public final int worldWidth = tileSize * maxWorldCol;
//    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;
    Thread gameThread;
    public KeyHandler keyH = new KeyHandler();
    public Player player = new Player(this, keyH);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public Entity[] monsters= new Entity[10];
    public TileManager tileManager = new TileManager(this);
    public boolean gameOver;
    public String DifficultLevel = "hardest";
    public PathFinderUsingDfs pathFinderUsingDfs = new PathFinderUsingDfs(this);
    public PathFinderUsingBfs pathFinderUsingBfs = new PathFinderUsingBfs(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void setUpGame() {
        assetSetter.setMonster();
    }

    public void update() {
        if (gameOver) return;
        player.update();
        for (Entity monster : monsters) {
            if (monster != null) {
                monster.update();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);
        
        //monster
        for (Entity monster : monsters) {
            if (monster != null) {
                monster.draw(g2, this);
            }
        }
        g2.dispose();
    }
}
