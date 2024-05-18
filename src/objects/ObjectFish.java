package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectFish extends SuperObjects{
    public ObjectFish() {
        name = "Fish";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/fish.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
