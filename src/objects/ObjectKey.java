package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectKey extends SuperObjects{
    public ObjectKey() {
        name = "Key";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
