import javax.swing.*;
import java.awt.*;

public class AddProductView {

    JButton btnAdd = new JButton("Add");
    JButton btnCancel = new JButton("Cancel");

    public AddProductView() {
        this.setTitle("Add Product");
        this.setSize(600, 400);
        this.getContentPane().setLayout(new SpringLayout());
        String[] labels = {"ProductID: ", "Fax: ", "Email: ", "Address: "};
        int numPairs = labels.length;

        Object p = new this.getContentPane();
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            JPanel p = new JPanel(new FlowLayout());
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }

        JPanel panelButtons = new JPanel(new FlowLayout());
        this.getContentPane().add(btnAdd);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(panelButtons);
    }
}
