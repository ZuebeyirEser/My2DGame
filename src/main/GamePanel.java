package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {




    // Screen Settings
    private final int originalTileSize = 16;
    private final int scale = 3;



    private final int tileSize = originalTileSize * scale;
    private final int maxScreenColumn = 21;
    private final int maxScreenRow = 13;
    private final int screenWitdh = tileSize * maxScreenColumn;
    private final int screenHeight = tileSize * maxScreenRow;



    private int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    Thread gameThread;
    Player player = new Player(this,keyHandler);



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWitdh,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
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
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
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

    public int getScreenWitdh() {
        return screenWitdh;
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
}
