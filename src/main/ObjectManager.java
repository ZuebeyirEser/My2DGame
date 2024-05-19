package main;

import objects.*;

public class ObjectManager {
    GamePanel gamePanel;
    public ObjectManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObject() {
        gamePanel.superObjectsArray[0] = new ObjectKey();
        gamePanel.superObjectsArray[0].worldX = 34 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[0].worldY = 45 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[1] = new ObjectKey();
        gamePanel.superObjectsArray[1].worldX = 5 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[1].worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[2] = new ObjectKey();
        gamePanel.superObjectsArray[2].worldX = 48 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[2].worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[3] = new ObjectKey();
        gamePanel.superObjectsArray[3].worldX = 16 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[3].worldY = 16 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[4] = new ObjectDoor();
        gamePanel.superObjectsArray[4].worldX = 19 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[4].worldY = 8 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[5] = new ObjectDoor();
        gamePanel.superObjectsArray[5].worldX = 9 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[5].worldY = 9 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[6] = new ObjectDoor();
        gamePanel.superObjectsArray[6].worldX = 33 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[6].worldY = 25 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[7] = new ObjectDoor();
        gamePanel.superObjectsArray[7].worldX = 18 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[7].worldY = 40 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[8] = new ObjectFish();
        gamePanel.superObjectsArray[8].worldX = 14 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[8].worldY = 23 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[9] = new ObjectMouse();
        gamePanel.superObjectsArray[9].worldX = 3 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[9].worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[10] = new ObjectMouse();
        gamePanel.superObjectsArray[10].worldX = 17 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[10].worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[11] = new ObjectMouse();
        gamePanel.superObjectsArray[11].worldX = 7 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[11].worldY = 37 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[12] = new ObjectMouse();
        gamePanel.superObjectsArray[12].worldX = 35 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[12].worldY = 31 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[13] = new ObjectTramboline();
        gamePanel.superObjectsArray[13].worldX = 20 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[13].worldY = 21 * gamePanel.getTileSize();

        gamePanel.superObjectsArray[14] = new ObjectKey();
        gamePanel.superObjectsArray[14].worldX = 40 * gamePanel.getTileSize();
        gamePanel.superObjectsArray[14].worldY = 40 * gamePanel.getTileSize();




    }
}
