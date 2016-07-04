package Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by cerebro on 04/07/16.
 */
public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);

        frame.pack();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Resource.load();


        Graphics graphics1 = panel.getGraphics();


        List<Element> elements = new ArrayList<>();

        elements.add(new Block(900, 405));
        elements.add(new Block(1100, 405));
        elements.add(new Block(1300, 405));
        elements.add(new Block(1500, 405));
        elements.add(new Block(1700, 405));
        elements.add(new Player(400, 365));

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
}
