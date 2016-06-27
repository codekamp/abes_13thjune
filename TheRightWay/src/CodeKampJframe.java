import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 23/06/16.
 */
public class CodeKampJframe extends JFrame implements ActionListener {


    public static int count = 0;

    private JButton changeColorButton;
    private JButton duplicateButton;
    private JLabel textLabel;

    private  List<CodeKampJframe> childWindows = new ArrayList<>();

    public CodeKampJframe() {
        this("CodeKamp");
    }

    public CodeKampJframe(String title) {
        super(title);

        CodeKampJframe.count++;
        this.setTitle("Window number " + CodeKampJframe.count);


        this.setDefaultCloseOperation(CodeKampJframe.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        JPanel panel1 = new JPanel();
        this.setContentPane(panel1);

        this.changeColorButton = new JButton("Change Color");
        panel1.add(this.changeColorButton);

        this.duplicateButton = new JButton("Duplicate");
        panel1.add(this.duplicateButton);

        this.textLabel = new JLabel("Hello world!");
        panel1.add(this.textLabel);

        this.changeColorButton.addActionListener(this);
        this.duplicateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.changeColorButton) {

            this.changeColor();

        } else if (e.getSource() == this.duplicateButton) {
            CodeKampJframe frame = new CodeKampJframe();

            this.childWindows.add(frame);
            frame.setVisible(true);
        }
    }

    public void changeColor() {


        this.textLabel.setForeground(Color.red);

        for (int i = 0; i < this.childWindows.size(); i++) {
            CodeKampJframe childWindow = this.childWindows.get(i);
            childWindow.changeColor();
        }
    }
}
