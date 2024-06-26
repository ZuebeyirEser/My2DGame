package main;

import entity.Player;
import objects.SuperObjects;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private int FPS = 60;


    // System
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    KeyHandler keyHandler = new KeyHandler();
    public Player player = new Player(this,keyHandler);
    TileManager tileManager = new TileManager(this);
    public CollisionManager collisionManager = new CollisionManager(this);
    Thread gameThread;

    // Entity and Object
    public ObjectManager objectManager = new ObjectManager(this);
    public ArrayList<SuperObjects> superObjectsArrayList = new ArrayList<>();

    public UserInterface userInterface = new UserInterface(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public void setUpTheGame() {
        objectManager.setObject();
        playMusic(0);
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
        for (int i = 0; i < superObjectsArrayList.size(); i++) {
            if (superObjectsArrayList.get(i) != null) {
                superObjectsArrayList.get(i).draw(graphics2D,this);
            }
        }
        // player
        player.draw(graphics2D);
        // UI for keys
        userInterface.draw(graphics2D);

        graphics2D.dispose();
    }
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    }

    public void playSoundEffect(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
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

}
