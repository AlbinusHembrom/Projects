public class AHProductBilling {
    // Overloaded methods for 1, 2, and 3 products
    public double calculateBill(double p1) {
        return p1;
    }

    public double calculateBill(double p1, double p2) {
        return p1 + p2;
    }

    public double calculateBill(double p1, double p2, double p3) {
        return p1 + p2 + p3;
    }

    // Discount calculation
    public double calculateBill(double total, int discountPercentage) {
        return total - (total * discountPercentage / 100);
    }
}