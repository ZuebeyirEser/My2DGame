package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[10];
        mapTileNum = new int[gamePanel.getMaxWorldColumn()][gamePanel.getMaxWorldRow()];
        getTileImage();
        loadMap("/maps/world-map.txt");

    }

    public void loadMap(String mapPath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(mapPath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col = 0;
            int row = 0;
            while (col < gamePanel.getMaxWorldColumn() && row < gamePanel.getMaxWorldRow()) {
                String line = bufferedReader.readLine();
                while (col < gamePanel.getMaxWorldColumn()) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gamePanel.getMaxWorldColumn()) {
                    col = 0;
                    row++;
                }

            }
            bufferedReader.close();
        } catch (Exception e) {

        }
    }
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));


            tile[1] = new Tile();
            tile[1].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].setCollision(true);

            tile[2] = new Tile();
            tile[2].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

            tile[3] = new Tile();
            tile[3].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

            tile[4] = new Tile();
            tile[4].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].setCollision(true);

            tile[5] = new Tile();
            tile[5].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D) {
//        graphics2D.drawImage(tile[0].bufferedImage,0,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
//        graphics2D.drawImage(tile[1].bufferedImage,48,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
//        graphics2D.drawImage(tile[2].bufferedImage,96,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);

        int worldColumn = 0;
        int worldRow = 0;


        while (worldColumn < gamePanel.getMaxWorldColumn() && worldRow < gamePanel.getMaxWorldRow()) {
            int tileNum = mapTileNum[worldColumn][worldRow];

            int worldX = worldColumn * gamePanel.getTileSize();
            int worldY = worldRow * gamePanel.getTileSize();
            int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.getScreenX();
            int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.getScreenY();
            if (worldX + gamePanel.getTileSize() > gamePanel.player.getWorldX() - gamePanel.player.getScreenX() &&
                    worldX - gamePanel.getTileSize() < gamePanel.player.getWorldX() + gamePanel.player.getScreenX() &&
                    worldY + gamePanel.getTileSize() > gamePanel.player.getWorldY() - gamePanel.player.getScreenY() &&
                    worldY - gamePanel.getTileSize() < gamePanel.player.getWorldY() + gamePanel.player.getScreenY()) {
                graphics2D.drawImage(tile[tileNum].bufferedImage,screenX,screenY,gamePanel.getTileSize(),gamePanel.getTileSize(),null);

            }
            worldColumn++;

            if (worldColumn == gamePanel.getMaxWorldColumn()) {
                worldColumn = 0;
                worldRow++;
            }
        }
    }

}
