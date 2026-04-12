public class AHProduct {
    private int productId;
    private String productName;
    private double price;

    // Overloaded constructor
    public AHProduct() {
        this.productId = 0;
        this.productName = "Unknown";
        this.price = 0.0;
    }

    public AHProduct(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }
}