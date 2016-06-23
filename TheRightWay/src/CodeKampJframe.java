import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 23/06/16.
 */
public class CodeKampJframe extends JFrame implements ActionListener {


    private JButton changeColorButton;
    private JButton duplicateButton;
    private JLabel textLabel;

    private CodeKampJframe[] childWindows = new CodeKampJframe[10];
    private int childrenCount = 0;

    public CodeKampJframe() {
        this("CodeKamp");
    }

    public CodeKampJframe(String title) {
        super(title);

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
            Color myCustomColor = new Color(160, 189, 255);
            this.textLabel.setForeground(myCustomColor);
        } else if (e.getSource() == this.duplicateButton) {
            CodeKampJframe frame = new CodeKampJframe();
            this.childWindows[this.childrenCount] = frame;
            this.childrenCount++;
            frame.setVisible(true);
        }
    }
}
