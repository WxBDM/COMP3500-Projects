public class CustomerModel {
    public java.lang.String mName;
    public int mCustomerID;
    public String mAddress;
    public int mPhone;
    public String mPaymentInfo;


    public String to_string() {
        StringBuilder sb = new StringBuilder("Product Details:\n");
        sb.append("\tCustomer ID: ").append(mCustomerID).append("\n");
        sb.append("\tCustomer Name: ").append(mName).append("\n");
        sb.append("\tCustomer Address: ").append(mAddress).append("\n");
        sb.append("\tCustomer Phone Number: ").append(mPhone).append("\n");
        sb.append("\tCustomer Payment Info: ").append(mPaymentInfo).append("\n");
        return sb.toString();
    }
}
