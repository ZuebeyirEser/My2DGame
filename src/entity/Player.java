package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel,KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        setX(100);
        setY(100);
        setSpeed(4);
        setDirection("down");
    }
        public void getPlayerImage() {
            try {
                setUp1(ImageIO.read(getClass().getResourceAsStream("/player/cat-up-1.png")));
                setUp2(ImageIO.read(getClass().getResourceAsStream("/player/cat-up-2.png")));
                setDown1(ImageIO.read(getClass().getResourceAsStream("/player/cat-down-1.png")));
                setDown2(ImageIO.read(getClass().getResourceAsStream("/player/cat-down-2.png")));
                setRight1(ImageIO.read(getClass().getResourceAsStream("/player/cat-right-1.png")));
                setRight2(ImageIO.read(getClass().getResourceAsStream("/player/cat-right-2.png")));
                setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/cat-left-1.png")));
                setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/cat-left-2.png")));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if (keyHandler.upPressed == true) {
                setDirection("up");
                setY(getY() - getSpeed());
            } else if (keyHandler.downPressed == true) {
                setDirection("down");
                setY(getY() + getSpeed());
            } else if (keyHandler.leftPressed == true) {
                setDirection("left");
                setX(getX() - getSpeed());
            } else if (keyHandler.rightPressed == true) {
                setDirection("right");
                setX(getX() + getSpeed());
            }
            incrementSpriceCounter();
            if (getSpriteCounter() > 12) {
                if (getSpriteCounter() == 1) {
                    setSpriteNumber(2);
                } else if (getSpriteCounter() == 2) {
                    setSpriteNumber(1);
                }
                setSpriteCounter(0);
            }
        }
    }
    public void draw(Graphics2D graphics2D) {
//     graphics2D.setColor(Color.white);
//     graphics2D.fillRect(x,y,gamePanel.getTileSize(), gamePanel.getTileSize());
        BufferedImage bufferedImage =  null;

        switch (getDirection()) {
            case "up":
                if (getSpriteNumber() == 1) {
                    bufferedImage = getUp1();
                }
                if (getSpriteNumber() == 2) {
                    bufferedImage = getUp2();
                }
                break;
            case "down":
                if (getSpriteNumber() == 1) {
                    bufferedImage = getDown1();
                }
                if (getSpriteNumber() == 2) {
                    bufferedImage = getDown2();
                }
                break;
            case "left":
                if (getSpriteNumber() == 1) {
                    bufferedImage = getLeft1();
                }
                if (getSpriteNumber() == 2) {
                    bufferedImage = getLeft2();
                }
                break;
            case "right":
                if (getSpriteNumber() == 1) {
                    bufferedImage = getRight1();
                }
                if (getSpriteNumber() == 2) {
                    bufferedImage = getRight2();
                }
                break;
        }
        graphics2D.drawImage(bufferedImage,
                getX(),
                getY(),
                gamePanel.getTileSize(),
                gamePanel.getTileSize(),
                null);

    }

}
