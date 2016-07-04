package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;


/**
 * Created by cerebro on 04/07/16.
 */

public class Demo implements KeyListener {

    public static Player player1;
    public static Player player2;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);
        panel.setFocusable(true);
        panel.addKeyListener(new Demo());

        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Resource.load();
        panel.requestFocus();


        Graphics graphics1 = panel.getGraphics();


        List<Element> elements = new ArrayList<>();


        Demo.player1 = new Player(300, 365);
        Demo.player2 = new SuperPlayer(600, 365);

        elements.add(new Block(900, 405));
        elements.add(new Block(1100, 405));
        elements.add(new Block(1300, 405));
        elements.add(new Block(1500, 405));
        elements.add(new Block(1700, 405));
        elements.add(Demo.player1);
        elements.add(Demo.player2);

        while (true) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            graphics1.clearRect(0, 0, 800, 500);


            graphics1.drawImage(Resource.grassImage, 0, 455, null);

            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                element.update();

                graphics1.drawImage(element.image, element.x, element.y, null);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Demo.player1.jump();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Demo.player2.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
