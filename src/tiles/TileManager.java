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
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[10];
        mapTileNum = new int[gamePanel.getMaxScreenColumn()][gamePanel.getMaxScreenRow()];
        getTileImage();

    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col = 0;
            int row = 0;
            while (col < gamePanel.getMaxScreenColumn() && row < gamePanel.getMaxScreenRow()) {
                String line = bufferedReader.readLine();
                while (col < gamePanel.getMaxScreenColumn()) {
                    String numbers[] = line.split(" ");
                }
            }
        } catch (Exception e) {

        }
    }
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2] = new Tile();
            tile[2].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D) {
//        graphics2D.drawImage(tile[0].bufferedImage,0,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
//        graphics2D.drawImage(tile[1].bufferedImage,48,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
//        graphics2D.drawImage(tile[2].bufferedImage,96,0,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gamePanel.getMaxScreenColumn() && row < gamePanel.getMaxScreenRow()) {
            graphics2D.drawImage(tile[0].bufferedImage,x,y,gamePanel.getTileSize(),gamePanel.getTileSize(),null);
            col++;
            x += gamePanel.getTileSize();
            if (col == gamePanel.getMaxScreenColumn()) {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.getTileSize();

            }
        }
    }
}
