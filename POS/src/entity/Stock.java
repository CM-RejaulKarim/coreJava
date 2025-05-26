package entity;

public class Stock {

    private String productName;
    private float quantity;
    private String category;

    public Stock() {
    }

    public Stock(String productName, float quantity, String category) {
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
