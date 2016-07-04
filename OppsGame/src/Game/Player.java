package Game;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by cerebro on 04/07/16.
 */
public class Player extends Element {
    public int jumpVelocity;

    public Player(int x, int y) {
        super(x, y, 72, 90);

        this.image = Resource.playerImage;
        this.jumpVelocity = -30;
    }

    public void jump() {
        if (this.y == 365) {
            Resource.jump.play();
            this.yVel = this.jumpVelocity;
            this.yAcc = 2;
        }
    }

    public void update() {
        super.update();

        if (this.y >= 365) {
            this.y = 365;
            this.yAcc = 0;
            this.yVel = 0;
        }
    }

}
