
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    public JFrame view;

    public JButton btnAddProduct = new JButton("Add New Product");
    public JButton btnAddCustomer = new JButton("Add New Customer");
    public JButton btnAddPurchase = new JButton("Add New Purchase");
    public JButton btnManageCustomer = new JButton("Manage Customers");
    public JButton btnManageProduct = new JButton("Manage Products");
    public JButton btnUpdateProduct = new JButton("Update Product Information");
    public JButton btnUpdateCustomer = new JButton("Update Customer Information");
    public JButton btnUpdatePurchase = new JButton("Update Purchase Information");
//    public JButton btnMakeNewPurchase = new JButton("Make a new Purchase");
//    public JButton btnViewPurchaseHistory = new JButton("View Purchase History ");
//    public JButton btnCancelPurchase = new JButton("SetUpSystemConfiguration ");
//    public JButton btnMakeNewPurchase = new JButton("Make a new Purchase");
//    public JButton btnViewPurchaseHistory = new JButton("View Purchase History ");
//    public JButton btnCancelPurchase = new JButton("Cancel Purchase ");

    public MainUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        view.setTitle("Customer");
        //view.setTitle("Admin");
        view.setTitle("Store Management System");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        //JLabel title = new JLabel("Customer System");
        //JLabel title = new JLabel("Admin Management System");
        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAddProduct);
        panelButtons.add(btnAddCustomer);
        panelButtons.add(btnAddPurchase);
        panelButtons.add(btnUpdateProduct);
        panelButtons.add(btnUpdateCustomer);
        panelButtons.add(btnManageCustomer);
        panelButtons.add(btnManageProduct);
        panelButtons.add(btnUpdatePurchase);
//        panelButtons.add(btnSetUpSystemConfiguration);
//        panelButtons.add(btnAddNewUser);
//        panelButtons.add(btnDeleteExistingUser);
//        panelButtons.add(btnMakeNewPurchase);
//        panelButtons.add(btnViewPurchaseHistory);
//        panelButtons.add(btnCancelPurchase);

        view.getContentPane().add(panelButtons);

        btnAddProduct.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddProductUI ap = new AddProductUI();
                ap.run();
            }


        });

        btnAddCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCustomerUI ac = new AddCustomerUI();
                ac.run();
            }


        });

        btnAddPurchase.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddPurchaseUI ax = new AddPurchaseUI();
                ax.run();
            }
        });

        btnManageCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageCustomerUI umc = new ManageCustomerUI();
                umc.run();
            }
        });

        btnManageProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageProductUI ump = new ManageProductUI();
                ump.run();
            }
        });

        btnUpdateProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateProductUI up = new UpdateProductUI();
                up.run();
            }
        });

        btnUpdateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateCustomerUI uc = new UpdateCustomerUI();
                uc.run();
            }
        });

        btnUpdatePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UpdatePurchaseUI uz = new UpdatePurchaseUI();
                uz.run();
            }
        });


    }
}
