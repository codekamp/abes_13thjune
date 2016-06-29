import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by cerebro on 28/06/16.
 */
public class Demo implements KeyListener {

    private static int xVel = 0;
    private static int yVel = 0;
    private static int startAngle = 0;

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


        panel1.setFocusable(true);
        panel1.requestFocus();
        Demo demo1 = new Demo();
        panel1.addKeyListener(demo1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }

        Graphics graphics1 = panel1.getGraphics();

        graphics1.setColor(Color.green);


        int x = 0;
        int y = 0;

        while (true) {
            x = x + Demo.xVel;
            y = y + Demo.yVel;

            graphics1.clearRect(0, 0, 600, 500);
            graphics1.fillArc(x, y, 100, 100, Demo.startAngle, 270);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Demo.xVel = 3;
            Demo.yVel = 0;
            Demo.startAngle = 45;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            Demo.xVel = -3;
            Demo.yVel = 0;
            Demo.startAngle = 225;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            Demo.xVel = 0;
            Demo.yVel = 3;
            Demo.startAngle = 315;
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            Demo.xVel = 0;
            Demo.yVel = -3;
            Demo.startAngle = 135;
        } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Demo.xVel = 0;
            Demo.yVel = 0;
        } else {
            System.out.println("Some other key pressed, so neglecting it.");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
