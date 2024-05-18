package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectTramboline extends SuperObjects{
    public ObjectTramboline() {
        name = "Mouse";
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/objects/tramboline.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
