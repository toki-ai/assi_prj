package model.entity;

public class Product {
    private int productID; 
    private String productName;
    private int supplierID;
    private String categoryName;
    private String quantityPerUnit; 
    private double unitPrice; 
    private String productImage;

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

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Product() {
    }

    public Product(int productID, String productName, int supplierID, String categoryName, String quantityPerUnit, double unitPrice, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryName = categoryName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", supplierID=" + supplierID + ", categoryName =" + categoryName + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + ", productImage=" + productImage + '}';
    }
}
