package objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObjects {
    public BufferedImage bufferedImage;
    public String name ;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D graphics2D, GamePanel gamePanel) {
        int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.getScreenX();
        int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.getScreenY();
        if (worldX + gamePanel.getTileSize() > gamePanel.player.getWorldX() - gamePanel.player.getScreenX() &&
                worldX - gamePanel.getTileSize() < gamePanel.player.getWorldX() + gamePanel.player.getScreenX() &&
                worldY + gamePanel.getTileSize() > gamePanel.player.getWorldY() - gamePanel.player.getScreenY() &&
                worldY - gamePanel.getTileSize() < gamePanel.player.getWorldY() + gamePanel.player.getScreenY()) {
            graphics2D.drawImage(bufferedImage,screenX,screenY,gamePanel.getTileSize(),gamePanel.getTileSize(),null);

        }
    }

}
