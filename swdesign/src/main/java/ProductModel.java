
public class ProductModel {
    public int mProductID, mQuantity;
    public String mName;
    public double mPrice;


    public String to_string() {
        StringBuilder sb = new StringBuilder("Product Details:\n");
        sb.append("\tProduct ID: ").append(mProductID).append("\n");
        sb.append("\tProduct Name: ").append(mName).append("\n");
        sb.append("\tProduct Price: $").append(mPrice).append("\n");
        sb.append("\tProduct Quantity: ").append(mQuantity).append("\n");
        return sb.toString();
    }

    public String insert_into_sql() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mProductID).append(", ");
        sb.append("\"").append(mName).append("\",");
        sb.append(mPrice).append(", ");
        sb.append(mQuantity).append(");");
        return sb.toString();
    }
}
