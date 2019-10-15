import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataAdapter implements IDataAdapter {

    public static final int PRODUCT_DUPLICATE_ERROR = 1;
    public static final int CUSTOMER_DUPLICATE_ERROR = 1;
    public static final int PURCHASE_DUPLICATE_ERROR = 1;

    public static final int PRODUCT_SAVED_OK = 0;
    public static final int CUSTOMER_SAVED_OK = 0;
    public static final int PURCHASE_SAVED_OK = 0;

    Connection conn = null;

    public int connect(String dbfile) {
        try {
            // db parameters
            String url = "jdbc:sqlite:data/" + dbfile;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            // In order to get the connection correct, see the first solution:
            // https://stackoverflow.com/questions/43161060/java-sqlite-connection-no-suitable-driver-found-for-jdbcsqlitemain-db

            System.out.println("Connection to SQLite has been established.");

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

    public int saveProduct(ProductModel product) {
        try {
            String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product.insert_into_sql();
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

    public int savePurchase(PurchaseModel purchase) {
        try {
            String sql = "INSERT INTO Purchases(PurchaseId, CustomerId, ProductId, Price, Quantity, Cost, Tax, Total, Date) VALUES " + purchase.insert_into_sql();
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PURCHASE_DUPLICATE_ERROR;
        }

        return PURCHASE_SAVED_OK;
    }

    public int saveCustomer(CustomerModel customer) {
        try {
            String sql = "INSERT INTO Customer VALUES " + customer.insert_into_sql();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            if (msg.contains("UNIQUE constraint failed"))
                return CUSTOMER_DUPLICATE_ERROR;
        }
        return CUSTOMER_SAVED_OK;
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = null;

        try {
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                product = new ProductModel();
                product.mProductID = rs.getInt("ProductId");
                product.mName = rs.getString("Name");
                product.mPrice = rs.getDouble("Price");
                product.mQuantity = rs.getInt("Quantity");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public CustomerModel loadCustomer(int id) {
        CustomerModel customer = null;

        try {
            String sql = "SELECT * FROM Customer WHERE CustomerId = " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                customer = new CustomerModel();
                customer.mCustomerID = id;
                customer.mName = rs.getString("Name");
                customer.mPhone = rs.getInt("Phone");
                customer.mAddress = rs.getString("Address");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
