package MyPackage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cerebro on 09/07/16.
 */
public class Demo {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //element adding started


        MySecondForm form = new MySecondForm();

        frame.setContentPane(form.panel1);


        //element adding ended


        frame.pack();
        frame.setVisible(true);


    }
}
