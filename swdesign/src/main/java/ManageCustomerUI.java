import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageCustomerUI {

    public JFrame view;

    public JButton btnLoad = new JButton("Load Customer");
    public JButton btnSave = new JButton("Save Customer");

    public JTextField txtCustomerID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPaymentMethod = new JTextField(20);
    public JTextField txtPhoneNumber = new JTextField(20);


    public ManageCustomerUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Manage Customer Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnLoad);
        panelButtons.add(btnSave);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("CustomerID "));
        line1.add(txtCustomerID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Name "));
        line2.add(txtName);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("PaymentMethod "));
        line3.add(txtPaymentMethod);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("PhoneNumber "));
        line4.add(txtPhoneNumber);
        view.getContentPane().add(line4);


        btnLoad.addActionListener(new LoadButtonListener());

        btnSave.addActionListener(new SaveButtonListener());

    }

    public void run() {
        view.setVisible(true);
    }

    class LoadButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel customer = new CustomerModel();
            String id = txtCustomerID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
                return;
            }

            try {
                customer.mCustomerID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            // call data access!

            customer = StoreManager.getInstance().getDataAdapter().loadCustomer(customer.mCustomerID);

            if (customer == null) {
                JOptionPane.showMessageDialog(null, "Customer NOT exists!");
            } else {
                txtName.setText(customer.mName);
                txtPaymentMethod.setText(customer.mPaymentMethod);
                txtPhoneNumber.setText(customer.mPhoneNumber);
            }
        }
    }

    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel customer = new CustomerModel();
            String id = txtCustomerID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
                return;
            }

            try {
                customer.mCustomerID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            String name = txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
                return;
            }

            customer.mName = name;

            String paymentMethod = txtPaymentMethod.getText();
            if (paymentMethod.length() == 0) {
                JOptionPane.showMessageDialog(null, "PaymentMethod name cannot be empty!");
                return;
            }

            customer.mPaymentMethod = paymentMethod;

            String phone = txtPhoneNumber.getText();
            if (phone.length() == 0) {
                JOptionPane.showMessageDialog(null, "PhoneNumber cannot be empty!");
                return;
            }

            customer.mPhoneNumber = phone;


            int res = StoreManager.getInstance().getDataAdapter().saveCustomer(customer);

            if (res == IDataAdapter.CUSTOMER_SAVE_FAILED)
                JOptionPane.showMessageDialog(null, "Customer is NOT saved successfully!");
            else
                JOptionPane.showMessageDialog(null, "Customer is SAVED successfully!");
        }
    }
}