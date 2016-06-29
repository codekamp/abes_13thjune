package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by cerebro on 27/06/16.
 */

public class Demo implements KeyListener {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);

        frame.pack();

        panel.setFocusable(true);
        panel.addKeyListener(new Demo());
        panel.requestFocus();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Image player1Image = null;
        Image player2Image = null;
        Image player3Image = null;
        Image player4Image = null;
        Image player5Image = null;
        Image grassImage = null;

        try {
            player1Image = ImageIO.read(Demo.class.getResource("images/run_anim1.png"));
            player2Image = ImageIO.read(Demo.class.getResource("images/run_anim2.png"));
            player3Image = ImageIO.read(Demo.class.getResource("images/run_anim3.png"));
            player4Image = ImageIO.read(Demo.class.getResource("images/run_anim4.png"));
            player5Image = ImageIO.read(Demo.class.getResource("images/run_anim5.png"));
            grassImage = ImageIO.read(Demo.class.getResource("images/grass.png"));

        } catch (Exception e) {
            System.out.println("something went wrong");
        }

        Image[] playerImages = {
                player1Image,
                player2Image,
                player3Image,
                player4Image,
                player5Image,
                player4Image,
                player3Image,
                player2Image,
        };




        Graphics graphics1 = panel.getGraphics();

        graphics1.setColor(Color.cyan);


        int playerImageIndex = 0;

        while (true) {

            playerImageIndex++;

            playerImageIndex = playerImageIndex % 8;

            graphics1.clearRect(0,0,800,500);

            graphics1.fillRect(0,0,800,500);
            graphics1.drawImage(grassImage, 0, 455, null);
            graphics1.drawImage(playerImages[playerImageIndex], 400, 365, null);

            try {
                Thread.sleep(40);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
