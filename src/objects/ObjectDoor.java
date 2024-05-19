package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectDoor extends SuperObjects {
    public ObjectDoor() {
        name = "Door";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
