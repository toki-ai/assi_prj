package model.entity;

public class ProductSales {
    private int productId;
    private String productName;
    private double totalPriceSold;

    public ProductSales(int productId, String productName, double totalPriceSold) {
        this.productId = productId;
        this.productName = productName;
        this.totalPriceSold = totalPriceSold;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPriceSold() {
        return totalPriceSold;
    }

    public void setTotalPriceSold(double totalPriceSold) {
        this.totalPriceSold = totalPriceSold;
    }

    @Override
    public String toString() {
        return "ProductSales{" + "productId=" + productId + ", productName=" + productName + ", totalPriceSold=" + totalPriceSold + '}';
    }
    
    
}
