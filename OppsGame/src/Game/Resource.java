package Game;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
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
    public static AudioClip jump;
    public static AudioClip hit;

    public static void load() {
        try {
            Resource.grassImage = ImageIO.read(Resource.class.getResource("images/grass.png"));
            Resource.blockImage = ImageIO.read(Resource.class.getResource("images/block.png"));
            Resource.playerImage = ImageIO.read(Resource.class.getResource("images/run_anim1.png"));
            Resource.backgroundColor = new Color(82, 167, 255);

            Resource.jump = Applet.newAudioClip(Resource.class.getResource("audios/onjump.wav"));
            Resource.hit = Applet.newAudioClip(Resource.class.getResource("audios/hit.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
