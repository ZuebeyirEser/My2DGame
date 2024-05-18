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
                if (gamePanel.tileManager.tile[tileNumberOne].collision == true || gamePanel.tileManager.tile[tileNumberTwo ].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].collision == true || gamePanel.tileManager.tile[tileNumberTwo].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftColumn = (entityLeftWorldX - entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].collision == true || gamePanel.tileManager.tile[tileNumberTwo].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightColumn = (entityRightWorldX + entity.getSpeed()) / gamePanel.getTileSize();
                tileNumberOne = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
                tileNumberTwo = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNumberOne].collision == true || gamePanel.tileManager.tile[tileNumberTwo ].collision == true) {
                    entity.setCollisionOn(true);
                }
                break;
        }

    }
}
