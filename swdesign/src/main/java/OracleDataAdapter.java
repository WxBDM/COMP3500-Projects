import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.SQLException;


public class OracleDataAdapter implements IDataAdapter {

    Connection conn = null;

    public int connect(String dbfile) {
        try {
            // db parameters
            String url = "jdbc:oracle:thin:store.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to Oracle Database has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return CONNECTION_OPEN_FAILED;
        }
        return CONNECTION_OPEN_OK;
    }

    @Override
    public int disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return CONNECTION_CLOSE_FAILED;
        }
        return CONNECTION_CLOSE_OK;
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = new ProductModel();

        try {
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            product.mProductID = rs.getInt("ProductId");
            product.mName = rs.getString("Name");
            product.mPrice = rs.getDouble("Price");
            product.mQuantity = rs.getInt("Quantity");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public int saveProduct(ProductModel product) {
        try {
            String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_DUPLICATE_ERROR;
        }

        return PRODUCT_SAVED_OK;
    }

    @Override
    public CustomerModel loadCustomer(int id) {
        return null;
    }

    @Override
    public int saveCustomer(CustomerModel customer) {
        try {
            String sql = "INSERT INTO Customer(ID, Name, Address, Phone, Payment) VALUES " + customer;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_DUPLICATE_ERROR;
        }
        return PRODUCT_SAVED_OK;

    }

    @Override
    public int savePurchase(PurchaseModel model) {
        return 0;
    }

}
