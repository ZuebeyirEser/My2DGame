package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectMouse extends SuperObjects{
    public ObjectMouse() {
        name = "Mouse";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/mouse.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
