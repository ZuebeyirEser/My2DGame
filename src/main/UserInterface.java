package main;

import objects.ObjectKey;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UserInterface {
    GamePanel gamePanel;
    Font courierFont;
    BufferedImage bufferedImage;

    private boolean messageOn = false;
    private String message = "";



    private int messageCounter = 0;

    public UserInterface(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        courierFont = new Font("Courier", Font.BOLD,21);
        ObjectKey objectKey = new ObjectKey();
        bufferedImage = objectKey.bufferedImage;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(courierFont);
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawImage(bufferedImage, 5,550,gamePanel.getTileSize()/2,gamePanel.getTileSize()/2,null);
        graphics2D.drawString("x"+ gamePanel.player.getHasKey(), 27, 573);

        if (isMessageOn()) {
            graphics2D.drawString(getMessage(), 55, 573);
            messageCounter++;
            if (messageCounter > 120){ // 120 FPS means 2 sec
                messageCounter = 0;
                messageOn = false;
            }
        }

    }

    public void displayMessage(String text) {
        message = text;
        messageOn = true;

    }

    // setter and getter

    public boolean isMessageOn() {
        return messageOn;
    }

    public void setMessageOn(boolean messageOn) {
        this.messageOn = messageOn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public int getMessageCounter() {
        return messageCounter;
    }
    public void setMessageCounter(int messageCounter) {
        this.messageCounter = messageCounter;
    }

}
