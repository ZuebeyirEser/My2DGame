package main;

import objects.ObjectKey;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UserInterface {
    GamePanel gamePanel;
    Font courierFont, arial_80BFont;
    BufferedImage bufferedImage;

    private boolean messageOn = false;
    private String message = "";
    private boolean gameFinished;




    private int messageCounter = 0;

    public UserInterface(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        courierFont = new Font("Courier", Font.PLAIN,21);
        arial_80BFont = new Font("Arial", Font.BOLD,80);
        ObjectKey objectKey = new ObjectKey();
        bufferedImage = objectKey.bufferedImage;
    }

    public void draw(Graphics2D graphics2D) {


        if (isGameFinished()) {

            graphics2D.setFont(courierFont);
            graphics2D.setColor(Color.RED);

            String text;
            int x,y,textLength;
            text = "You catch the mouse!";
            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
            x  = gamePanel.getScreenWidth()/2 - textLength/2;
            y  = gamePanel.getScreenHeight()/2 - (gamePanel.getTileSize()*3);
            graphics2D.drawString(text,x,y);


            graphics2D.setFont(arial_80BFont);
            graphics2D.setColor(Color.yellow);
            text = "Congratulations";
            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
            x  = gamePanel.getScreenWidth()/2 - textLength/2;
            y  = gamePanel.getScreenHeight()/2 + (gamePanel.getTileSize()*2);
            graphics2D.drawString(text,x,y);

            gamePanel.gameThread = null;

        } else {
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
    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

}
