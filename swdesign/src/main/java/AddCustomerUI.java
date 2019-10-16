import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerUI {

    public JFrame view;

    public JButton btnAdd = new JButton("Add");
    public JButton btnCancel = new JButton("Cancel");

    public JTextField txtProductID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtAddress = new JTextField(20);
    public JTextField txtPhoneNumber = new JTextField(20);
    public JTextField txtPaymentInfo = new JTextField(20);

    public AddCustomerUI()   {
        this.view = new JFrame();

        view.setTitle("Add Customer");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        String[] labels = {"CustomerID ", "Name ", "Address ", "Phone Number ", "Payment Info "};

        // Customer ID text box
        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("CustomerID: "));
        line1.add(txtProductID);
        view.getContentPane().add(line1);

        // Customer name text box
        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Name "));
        line2.add(txtName);
        view.getContentPane().add(line2);

        // Address text box
        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Address "));
        line3.add(txtAddress);
        view.getContentPane().add(line3);

        // Phone number text box
        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Phone Number "));
        line4.add(txtPhoneNumber);
        view.getContentPane().add(line4);

        // Payment info text box
        JPanel line5 = new JPanel(new FlowLayout());
        line5.add(new JLabel("Payment Info "));
        line5.add(txtPaymentInfo);
        view.getContentPane().add(line5);

        // The add and cancel buttons
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        view.getContentPane().add(panelButtons);

        btnAdd.addActionListener(new AddButtonListerner());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.dispose();
            }
        });
    }

    public void run() {
        view.setVisible(true);
    }

    class AddButtonListerner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel customer = new CustomerModel();

            // Need this because it's primary key - it cannot be left blank.
            String id = txtProductID.getText();
            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer ID cannot be null!");
                return;
            }

            try {
                customer.mCustomerID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Customer ID is invalid!");
                return;
            }

            // The name of the customer
            String name = txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
                return;
            }
            customer.mName = name; // checks are complete - add the customer name to the object.

            // Address of customer
            String address = txtAddress.getText();
            if (address.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer address cannot be empty!");
                return;
            }
            customer.mAddress = address; // checks are complete - add the customer address to the object

            // The phone number of the customer
            String quantity = txtPhoneNumber.getText();
            try {
                customer.mPhone = Integer.parseInt(quantity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Phone number is invalid");
                return;
            }

            // Address of customer
            String payment = txtAddress.getText();
            if (payment.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer address cannot be empty!");
                return;
            }
            customer.mPaymentInfo = payment; // checks are complete - add the customer address to the object

            switch (StoreManager.getInstance().getDataAdapter().saveCustomer(customer)) {
                case SQLiteDataAdapter.CUSTOMER_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Unsuccessful customer add. Duplicate customer ID.");
                    return;
                case SQLiteDataAdapter.CUSTOMER_SAVED_OK:
                    JOptionPane.showMessageDialog(null, "Customer added successfully!\n" + customer.to_string());
                    return;
                default:
                    return;
            }
        }
    }

}