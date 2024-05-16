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
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
        public void getPlayerImage() {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player/cat-up-1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player/cat-up-2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player/cat-down-1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player/cat-down-2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player/cat-right-1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player/cat-right-2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player/cat-left-1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player/cat-left-2.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D graphics2D) {
//     graphics2D.setColor(Color.white);
//     graphics2D.fillRect(x,y,gamePanel.getTileSize(), gamePanel.getTileSize());
        BufferedImage bufferedImage =  null;
        switch (direction) {
            case "up":
                if (spriteNumber == 1) {
                    bufferedImage = up1;
                }
                if (spriteNumber == 2) {
                    bufferedImage = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1) {
                    bufferedImage = down1;
                }
                if (spriteNumber == 2) {
                    bufferedImage = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    bufferedImage = left1;
                }
                if (spriteNumber == 2) {
                    bufferedImage = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    bufferedImage = right1;
                }
                if (spriteNumber == 2) {
                    bufferedImage = right2;
                }
                break;
        }
        graphics2D.drawImage(bufferedImage,
                x,
                y,
                gamePanel.getTileSize(),
                gamePanel.getTileSize(),
                null);

    }

}
