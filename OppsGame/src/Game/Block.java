package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by cerebro on 04/07/16.
 */
public class Block extends Element {


    public Block(int x, int y) {
        super(x, y, 20, 50);
        this.xVel = -5;
        this.image = Resource.blockImage;
    }
}
