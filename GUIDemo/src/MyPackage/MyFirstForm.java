package MyPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 09/07/16.
 */
public class MyFirstForm implements ActionListener {
    private JButton helloButton;
    public JPanel panel1;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton buttonThree;
    private JButton a6Button;
    private JButton button7;
    private JButton a5Button;
    private JButton a4Button;
    private JButton button10;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a0Button;
    private JTextField textField1;
    private JButton buttonOne;
    private JButton buttonTwo;

    public MyFirstForm() {
        super();

        this.buttonOne.addActionListener(this);
        this.buttonTwo.addActionListener(this);
        this.buttonThree.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();

        String existingText = this.textField1.getText();
        String newText = existingText + clickedButton.getText();
        this.textField1.setText(newText);
    }
}
