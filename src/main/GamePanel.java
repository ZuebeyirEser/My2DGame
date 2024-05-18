package main;

import entity.Player;
import objects.SuperObjects;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {




    // Screen Settings
    private final int originalTileSize = 16;
    private final int scale = 3;



    private final int tileSize = originalTileSize * scale;
    private final int maxScreenColumn = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenColumn;
    private final int screenHeight = tileSize * maxScreenRow;

    // World Settings
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    private final int worldWidth = tileSize * maxWorldCol;
    private final int worldHeight = tileSize * maxWorldRow;



    private int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    Thread gameThread;
    public Player player = new Player(this,keyHandler);
    TileManager tileManager = new TileManager(this);
    public CollisionManager collisionManager = new CollisionManager(this);
    public ObjectManager objectManager = new ObjectManager(this);
    public SuperObjects[] superObjects = new SuperObjects[15];

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public void setUpTheGame() {
        objectManager.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /*
    public void run() {

        double drawInterval = 1_000_000_000D / FPS; // a billion nano sec is equal to 1 sec
        double nextDrawTime = System.nanoTime() + drawInterval;
        // game loop
        while (gameThread != null) {

            // update
            update();
            // draw
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1_000_000;
                Thread.sleep((long) remainingTime);
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
     */
    @Override
    public void run() {

        double drawInterval = 1_000_000_000D / FPS; // a billion nano sec is equal to 1 sec
        double delta = 0;
        long lasTime = System.nanoTime();
        long currentTime ;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lasTime) / drawInterval;
            lasTime = currentTime;
            if (delta > 1) {
                update();
                repaint();
                delta--;
            }


        }


    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        // tile
        tileManager.draw(graphics2D);
        // Object
        for (int i = 0; i < superObjects.length;i++) {
            if (superObjects[i] != null) {
                superObjects[i].draw(graphics2D,this);
            }
        }
        // player
        player.draw(graphics2D);

        graphics2D.dispose();
    }





    // getter setter


    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getScale() {
        return scale;
    }
    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenColumn() {
        return maxScreenColumn;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }
    public int getMaxWorldColumn() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
}
