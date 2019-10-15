public class PurchaseModel {
    public int mPurchaseID, mProductID, mCustomerID;
    public double mPrice, mQuantity, mCost, mTax, mTotal;
    public String mDate;

    public String to_string() {
        StringBuilder sb = new StringBuilder("Product Details:\n");
        sb.append("\tPurchase ID: ").append(mPurchaseID).append("\n");
        sb.append("\tCustomer ID: ").append(mCustomerID).append("\n");
        sb.append("\tProduct ID: ").append(mProductID).append("\n");
        sb.append("\tProduct Price: $").append(mPrice).append("\n");
        sb.append("\tProduct Quantity: ").append(mQuantity).append("\n");
        sb.append("\tProduct Cost: $").append(mCost).append("\n");
        sb.append("\tPurchase Tax: $").append(mTax).append("\n");
        sb.append("\tPurchase Total: $").append(mTotal).append("\n");
        sb.append("\tPurchase Date: ").append(mDate).append("\n");
        return sb.toString();
    }

    public String insert_into_sql() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mPurchaseID).append(", ");
        sb.append(mCustomerID).append(", ");
        sb.append(mProductID).append(", ");
        sb.append(mPrice).append(", ");
        sb.append(mQuantity).append(", ");
        sb.append(mCost).append(", ");
        sb.append(mTax).append(", ");
        sb.append(mTotal).append(", \"");
        sb.append(mDate).append("\")");
        return sb.toString();
    }
}


