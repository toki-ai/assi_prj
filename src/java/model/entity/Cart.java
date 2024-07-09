package model.entity;

public class Cart { 
    private int productID; 
    private String productName;
    private String productImage;
    private String categoryName; 
    private double unitPrice;
    private int quantity; 

    public Cart(int productID, String productName, String productImage, String categoryName, double unitPrice, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.categoryName = categoryName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" + "productID=" + productID + ", productName=" + productName + ", productImage=" + productImage + ", categoryName=" + categoryName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
    
    
}
