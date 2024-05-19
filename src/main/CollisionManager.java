package main;

import entity.Entity;

public class CollisionManager {
    GamePanel gamePanel;
    public CollisionManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + entity.solidAreaOfThePlayer.x;
        int entityRightWorldX = entity.getWorldX() + entity.solidAreaOfThePlayer.x + entity.solidAreaOfThePlayer.width;
        int entityTopWorldY = entity.getWorldY() + entity.solidAreaOfThePlayer.y;
        int entityBottomWorldY = entity.getWorldY() + entity.solidAreaOfThePlayer.y + entity.solidAreaOfThePlayer.height;

        int entityLeftColumn = entityLeftWorldX/gamePanel.getTileSize();
        int entityRightColumn = entityRightWorldX/gamePanel.getTileSize();
        int entityTopRow = entityTopWorldY/gamePanel.getTileSize();
        int entityBottomRow = entityBottomWorldY/gamePanel.getTileSize();

        int tileNumberOne, tileNumberTwo;
        switch (entity.getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityTopRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
                if (gamePanel.tileManager.tile[tileNumberOne].isCollision() == true || gamePanel.tileManager.tile[tileNumberTwo].isCollision() == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].isCollision() == true  || gamePanel.tileManager.tile[tileNumberTwo].isCollision() == true ) {
                    entity.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftColumn = (entityLeftWorldX - entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].isCollision() == true  || gamePanel.tileManager.tile[tileNumberTwo].isCollision() == true ) {
                    entity.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightColumn = (entityRightWorldX + entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].isCollision() == true  || gamePanel.tileManager.tile[tileNumberTwo].isCollision() == true) {
                    entity.setCollisionOn(true);
                }
                break;
        }

    }
    public int checkObject(Entity entity, boolean player) {
        int index = 6969;
        for (int i = 0; i < gamePanel.superObjectsArray.length; i++) {
            if (gamePanel.superObjectsArray[i] != null) {
                // get entity solid area position
                entity.solidAreaOfThePlayer.x = entity.getWorldX() + entity.solidAreaOfThePlayer.x;
                entity.solidAreaOfThePlayer.y = entity.getWorldY() + entity.solidAreaOfThePlayer.y;

                // get object solid area position
                gamePanel.superObjectsArray[i].solidArea.x = gamePanel.superObjectsArray[i].worldX + gamePanel.superObjectsArray[i].solidArea.x;
                gamePanel.superObjectsArray[i].solidArea.y = gamePanel.superObjectsArray[i].worldY + gamePanel.superObjectsArray[i].solidArea.y;
                switch (entity.getDirection()) {
                    case "up":
                        entity.solidAreaOfThePlayer.y -= entity.getSpeed();
                        if (entity.solidAreaOfThePlayer.intersects(gamePanel.superObjectsArray[i].solidArea)) {
                            if (gamePanel.superObjectsArray[i].collision == true) {
                                entity.setCollisionOn(true);
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidAreaOfThePlayer.y += entity.getSpeed();
                        if (entity.solidAreaOfThePlayer.intersects(gamePanel.superObjectsArray[i].solidArea)) {
                            if (gamePanel.superObjectsArray[i].collision == true) {
                                entity.setCollisionOn(true);
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidAreaOfThePlayer.x -= entity.getSpeed();
                        if (entity.solidAreaOfThePlayer.intersects(gamePanel.superObjectsArray[i].solidArea)) {
                            if (gamePanel.superObjectsArray[i].collision == true) {
                                entity.setCollisionOn(true);
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidAreaOfThePlayer.x += entity.getSpeed();
                        if (entity.solidAreaOfThePlayer.intersects(gamePanel.superObjectsArray[i].solidArea)) {
                            if (gamePanel.superObjectsArray[i].collision == true) {
                                entity.setCollisionOn(true);
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidAreaOfThePlayer.x =entity.getSolidAreaDefaultX();
                entity.solidAreaOfThePlayer.y =entity.getSolidAreaDefaultY();
                gamePanel.superObjectsArray[i].solidArea.x = gamePanel.superObjectsArray[i].solidAreaDefaultX;
                gamePanel.superObjectsArray[i].solidArea.y = gamePanel.superObjectsArray[i].solidAreaDefaultY;

            }


        }
        return index;
    }
}
