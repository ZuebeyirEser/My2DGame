package main;

import objects.*;

public class ObjectManager {
    GamePanel gamePanel;
    public ObjectManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObject() {


        gamePanel.superObjectsArrayList.add(new ObjectKey());
        gamePanel.superObjectsArrayList.get(0).worldX = 34 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(0).worldY = 45 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectKey());
        gamePanel.superObjectsArrayList.get(1).worldX = 5 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(1).worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectKey());
        gamePanel.superObjectsArrayList.get(2).worldX = 48 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(2).worldY = 48 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectKey());
        gamePanel.superObjectsArrayList.get(3).worldX = 16 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(3).worldY = 16 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectDoor());
        gamePanel.superObjectsArrayList.get(4).worldX = 19 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(4).worldY = 8 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectDoor());
        gamePanel.superObjectsArrayList.get(5).worldX = 9 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(5).worldY = 9 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectDoor());
        gamePanel.superObjectsArrayList.get(6).worldX = 33 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(6).worldY = 25 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectDoor());
        gamePanel.superObjectsArrayList.get(7).worldX = 18 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(7).worldY = 40 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectFish());
        gamePanel.superObjectsArrayList.get(8).worldX = 14 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(8).worldY = 23 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectMouse());
        gamePanel.superObjectsArrayList.get(9).worldX= 3 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(9).worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectMouse());
        gamePanel.superObjectsArrayList.get(10).worldX = 17 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(10).worldY = 3 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectMouse());
        gamePanel.superObjectsArrayList.get(11).worldX = 7 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(11).worldY = 37 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectMouse());
        gamePanel.superObjectsArrayList.get(12).worldX = 35 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(12).worldY = 31 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectTramboline());
        gamePanel.superObjectsArrayList.get(13).worldX = 20 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(13).worldY = 21 * gamePanel.getTileSize();

        gamePanel.superObjectsArrayList.add(new ObjectKey());
        gamePanel.superObjectsArrayList.get(14).worldX = 40 * gamePanel.getTileSize();
        gamePanel.superObjectsArrayList.get(14).worldY = 40 * gamePanel.getTileSize();




    }
}
