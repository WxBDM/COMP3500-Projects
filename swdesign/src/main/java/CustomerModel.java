

public class CustomerModel {
    public int mCustomerID;
    public String mName, mPaymentMethod, mPhoneNumber;


    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mCustomerID).append(",");
        sb.append("\"").append(mName).append("\"").append(",");
        sb.append("\"").append(mPaymentMethod).append("\",");
        sb.append("\"").append(mPhoneNumber).append("\"").append(")");
        return sb.toString();
    }
}

