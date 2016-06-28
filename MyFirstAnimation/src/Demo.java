import javax.swing.*;
import java.awt.*;

/**
 * Created by cerebro on 28/06/16.
 */
public class Demo {
    public static void main(String[] args) {

        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);

        JPanel panel1 = new JPanel();
        frame1.setContentPane(panel1);

        Dimension dimension = new Dimension(600, 500);
        panel1.setPreferredSize(dimension);

        frame1.pack();

        frame1.setVisible(true);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }

        Graphics graphics1 = panel1.getGraphics();

        graphics1.setColor(Color.green);


        int x = 0;
        int y = 0;
        int xVel = 3;
        int yVel = 3;
        while (true) {
            x = x + xVel;
            y = y + yVel;

            if (y >= 400) {
                yVel = -3;
            }

            if (x >= 500) {
                xVel = -3;
            }

            if (x <= 0) {
                xVel = 3;
            }

            if (y <= 0) {
                yVel = 3;
            }




            graphics1.clearRect(0, 0, 600, 500);
            graphics1.fillOval(x, y, 100, 100);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
