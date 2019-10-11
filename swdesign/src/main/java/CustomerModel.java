public class CustomerModel {
    public java.lang.String mName;
    public int mCustomerID;
    public String mAddress;
    public int mPhone;
    public String mPaymentInfo;


    public String to_string() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mName).append(",");
        sb.append(mCustomerID).append(",");
        sb.append(mAddress).append(",");
        sb.append(mPhone).append(",");
        sb.append(mPaymentInfo).append(")");
        return sb.toString();
    }
}
