public class AHProductBilling {
    // Method 1: Bill for 1 product
    void ahBill(int price) {
        System.out.println("Total bill of 1 product: " + price);
    }
    // Method 2: Bill for 2 product
    void ahBill(int price1, int price2) {
        System.out.println("Total bill for 2 product: " + (price1 + price2));
    }
    // Method 3: Bill for 3 product
    void ahBill(int price1, int price2, int price3) {
        System.out.println("Total bill for 3 product: " + (price1 + price2 + price3));
    }
    public static void main(String[] args) {
        // Creating object for Product Billing
        AHProductBilling pb = new AHProductBilling();

        // Call overload method
        pb.ahBill(100);
        pb.ahBill(250,200);
        pb.ahBill(150,180,300);
    }
}