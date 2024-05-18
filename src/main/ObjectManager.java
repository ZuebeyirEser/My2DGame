package main;

import objects.*;

public class ObjectManager {
    GamePanel gamePanel;
    public ObjectManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObject() {
        gamePanel.superObjects[0] = new ObjectKey();
        gamePanel.superObjects[0].worldX = 34 * gamePanel.getTileSize();
        gamePanel.superObjects[0].worldY = 45 * gamePanel.getTileSize();

        gamePanel.superObjects[1] = new ObjectKey();
        gamePanel.superObjects[1].worldX = 5 * gamePanel.getTileSize();
        gamePanel.superObjects[1].worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjects[2] = new ObjectKey();
        gamePanel.superObjects[2].worldX = 48 * gamePanel.getTileSize();
        gamePanel.superObjects[2].worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjects[3] = new ObjectKey();
        gamePanel.superObjects[3].worldX = 16 * gamePanel.getTileSize();
        gamePanel.superObjects[3].worldY = 16 * gamePanel.getTileSize();

        gamePanel.superObjects[4] = new ObjectDoor();
        gamePanel.superObjects[4].worldX = 19 * gamePanel.getTileSize();
        gamePanel.superObjects[4].worldY = 8 * gamePanel.getTileSize();

        gamePanel.superObjects[5] = new ObjectDoor();
        gamePanel.superObjects[5].worldX = 9 * gamePanel.getTileSize();
        gamePanel.superObjects[5].worldY = 9 * gamePanel.getTileSize();

        gamePanel.superObjects[6] = new ObjectDoor();
        gamePanel.superObjects[6].worldX = 33 * gamePanel.getTileSize();
        gamePanel.superObjects[6].worldY = 25 * gamePanel.getTileSize();

        gamePanel.superObjects[7] = new ObjectDoor();
        gamePanel.superObjects[7].worldX = 18 * gamePanel.getTileSize();
        gamePanel.superObjects[7].worldY = 40 * gamePanel.getTileSize();

        gamePanel.superObjects[8] = new ObjectFish();
        gamePanel.superObjects[8].worldX = 14 * gamePanel.getTileSize();
        gamePanel.superObjects[8].worldY = 23 * gamePanel.getTileSize();

        gamePanel.superObjects[9] = new ObjectMouse();
        gamePanel.superObjects[9].worldX = 3 * gamePanel.getTileSize();
        gamePanel.superObjects[9].worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjects[10] = new ObjectMouse();
        gamePanel.superObjects[10].worldX = 17 * gamePanel.getTileSize();
        gamePanel.superObjects[10].worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjects[11] = new ObjectMouse();
        gamePanel.superObjects[11].worldX = 7 * gamePanel.getTileSize();
        gamePanel.superObjects[11].worldY = 37 * gamePanel.getTileSize();

        gamePanel.superObjects[12] = new ObjectMouse();
        gamePanel.superObjects[12].worldX = 35 * gamePanel.getTileSize();
        gamePanel.superObjects[12].worldY = 31 * gamePanel.getTileSize();

        gamePanel.superObjects[13] = new ObjectTramboline();
        gamePanel.superObjects[13].worldX = 20 * gamePanel.getTileSize();
        gamePanel.superObjects[13].worldY = 21 * gamePanel.getTileSize();

        gamePanel.superObjects[14] = new ObjectKey();
        gamePanel.superObjects[14].worldX = 40 * gamePanel.getTileSize();
        gamePanel.superObjects[14].worldY = 40 * gamePanel.getTileSize();




    }
}
