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


    private final int screenX;
    private final int screenY;

    private int hasKey = 0;

    public Player(GamePanel gamePanel,KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.getScreenWidth()/2 - (gamePanel.getTileSize()/2);
        screenY = gamePanel.getScreenHeight()/2 - (gamePanel.getTileSize()/2);

        solidAreaOfThePlayer = new Rectangle();
        solidAreaOfThePlayer.x = 8;
        solidAreaOfThePlayer.y = 16;
        setSolidAreaDefaultX(solidAreaOfThePlayer.x);
        setSolidAreaDefaultY(solidAreaOfThePlayer.y);
        solidAreaOfThePlayer.width = 32;
        solidAreaOfThePlayer.height = 32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        setWorldX(gamePanel.getTileSize() * 20);
        setWorldY(gamePanel.getTileSize() * 15);
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

            } else if (keyHandler.downPressed == true) {
                setDirection("down");

            } else if (keyHandler.leftPressed == true) {
                setDirection("left");

            } else if (keyHandler.rightPressed == true) {
                setDirection("right");

            }
            // tile collision
            setCollisionOn(false);
            gamePanel.collisionManager.checkTile(this);
            // check object Collision
            int objectIndex = gamePanel.collisionManager.checkObject(this,true);
            grapTheObject(objectIndex);
            // if collision false , player can move
            if (isCollisionOn() == false) {
                switch (getDirection()) {
                    case "up":
                        setWorldY(getWorldY() - getSpeed());
                        break;
                    case "down":
                        setWorldY(getWorldY() + getSpeed());
                        break;
                    case "left":
                        setWorldX(getWorldX() - getSpeed());
                        break;
                    case "right":
                        setWorldX(getWorldX() + getSpeed());
                        break;
                }

            }

            incrementSpriteCounter();
            if (getSpriteCounter() > 7) {
                if (getSpriteNumber() == 1) {
                    setSpriteNumber(2);
                } else if (getSpriteNumber() == 2) {
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
                screenX,
                screenY,
                gamePanel.getTileSize(),
                gamePanel.getTileSize(),
                null);


    }
    public void grapTheObject(int i) {
        if (i != 6969) {
            String objectName = gamePanel.superObjectsArray[i].name;
            switch (objectName) {
                case "Key":
                    gamePanel.playSoundEffect(1);
                    hasKey++;
                    gamePanel.superObjectsArray[i] = null;
                    gamePanel.userInterface.displayMessage("Meow! you have a key");
                    break;
                case "Door", "Trampoline":
                    if (hasKey > 0) {
                        gamePanel.playSoundEffect(3);
                        gamePanel.superObjectsArray[i] = null;
                        hasKey--;
                        gamePanel.userInterface.displayMessage("You open the door");
                    } else {
                        gamePanel.userInterface.displayMessage("You need a key!");
                    }
                    break;
                case "Fish":
                    gamePanel.playSoundEffect(4);
                    setSpeed(getSpeed() + 2);
                    gamePanel.superObjectsArray[i] = null;
                    gamePanel.userInterface.displayMessage("Yummy time to speed up!");
                    break;
            }
        }
    }

    // getter setter
    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getHasKey() {
        return hasKey;
    }

    public void setHasKey(int hasKey) {
        this.hasKey = hasKey;
    }

}
