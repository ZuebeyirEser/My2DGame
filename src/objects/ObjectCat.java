package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectCat extends SuperObjects{
    public ObjectCat() {
        name = "Cat";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/cat.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
