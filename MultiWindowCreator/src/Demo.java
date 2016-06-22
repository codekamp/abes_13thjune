import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 22/06/16.
 */
public class Demo implements ActionListener {

    public static int windowCount = 0;

    public JLabel label1;
    public JButton button1;
    public JButton button2;

    public static void main(String[] args) {

        Demo.createWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("action performed of Demo class called");

        if (e.getSource() == this.button1) {
            System.out.println("hello world!");

            this.label1.setForeground(Color.red);
        } else if (e.getSource() == this.button2) {
            //code to duplicate window
            System.out.println("duplicate button clicked");
            Demo.createWindow();
        }
    }

    public static void createWindow() {

        Demo.windowCount++;

        //created a JFrame and set its close operation and size
        JFrame frame1 = new JFrame("Window number " + Demo.windowCount);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);

        // created a JPanel and set it as contentPane of frame
        JPanel panel1 = new JPanel();
        frame1.setContentPane(panel1);


        //now create elements and add them to JPanel

        // 1. create element
        // 2. configure it
        // 3. add it to JPanel



        Demo demo1 = new Demo();

        demo1.label1 = new JLabel();
        demo1.label1.setText("Hello world!");
        demo1.label1.setForeground(Color.green);
        panel1.add(demo1.label1);

        demo1.button1 = new JButton();
        demo1.button1.setText("change color");
        panel1.add(demo1.button1);

        demo1.button2 = new JButton();
        demo1.button2.setText("Duplicate");
        panel1.add(demo1.button2);


        demo1.button1.addActionListener(demo1);
        demo1.button2.addActionListener(demo1);

        frame1.setVisible(true);
    }
}
