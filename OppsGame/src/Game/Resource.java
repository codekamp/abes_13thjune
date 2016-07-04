package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by cerebro on 04/07/16.
 */
public class Resource {
    public static Image grassImage;
    public static Image blockImage;
    public static Image playerImage;
    public static Color backgroundColor;

    public static void load() {
        try {
            Resource.grassImage = ImageIO.read(Resource.class.getResource("images/grass.png"));
            Resource.blockImage = ImageIO.read(Resource.class.getResource("images/block.png"));
            Resource.playerImage = ImageIO.read(Resource.class.getResource("images/run_anim1.png"));
            Resource.backgroundColor = new Color(82, 167, 255);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
