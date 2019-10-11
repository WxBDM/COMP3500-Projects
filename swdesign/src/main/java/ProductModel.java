
public class ProductModel {
    public int mProductID, mQuantity;
    public String mName;
    public double mPrice;


    public String to_string() {
        StringBuilder sb = new StringBuilder("(");
        sb.append("\"").append(mProductID).append("\"").append(",");
        sb.append(mName).append(",");
        sb.append(mPrice).append(",");
        sb.append(mQuantity).append(")");
        return sb.toString();
    }
}
