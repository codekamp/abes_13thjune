package MyPackage;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by cerebro on 09/07/16.
 */
public class MySecondForm implements ListModel<String> {
    public JPanel panel1;
    private JList taskList;
    private JButton createButton;
    private JTextField textField1;

    public MySecondForm() {
        this.taskList.setModel(this);
    }

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public String getElementAt(int index) {
        return "item number " + index;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
