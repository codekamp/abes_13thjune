package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by cerebro on 04/07/16.
 */
abstract public class Element {

    public int x;
    public int y;
    public int xVel = 0;
    public int yVel= 0;
    public int xAcc = 0;
    public int yAcc = 0;
    public int width;
    public int height;

    public Image image;


    public Element(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        this.xVel += this.xAcc;
        this.yVel += this.yAcc;
        this.x += this.xVel;
        this.y += this.yVel;
    }
}
