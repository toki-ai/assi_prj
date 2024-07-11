package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entity.Product;
import utils.DBUtils;

public class ProductDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private String subQuery = "SELECT p.ProductID, p.ProductName, p.SupplierID, c.CategoryName, p.QuantityPerUnit, p.UnitPrice, p.ProductImage \n"
            + "FROM dbo.Products p JOIN dbo.Categories c \n"
            + "ON p.CategoryID = c.CategoryID ";

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = subQuery;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get all products in DAO " + e.getMessage());
        }
        return list;
    }

    public List<Product> getLoadMoreProduct(int row) {
        List<Product> list = new ArrayList<>();
        String query = subQuery + "ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, row);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get all products in DAO " + e.getMessage());
        }
        return list;
    }

    public List<Product> getTop3Product() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 3 p.ProductID, p.ProductName, p.SupplierID, c.CategoryName, p.QuantityPerUnit, p.UnitPrice, p.ProductImage \n"
                + "FROM dbo.Products p JOIN dbo.Categories c \n"
                + "ON p.CategoryID = c.CategoryID";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get all products in DAO " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductsByCategory(String categoryID) {
        List<Product> list = new ArrayList<>();
        String query = subQuery + " WHERE c.CategoryID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get products by category in DAO " + e.getMessage());
        }
        return list;
    }

    public List<Product> getProductsByName(String inputSearch) {
        List<Product> list = new ArrayList<>();
        String query = subQuery + " WHERE p.ProductName LIKE ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + inputSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get products by product name in DAO " + e.getMessage());
        }
        return list;
    }

    public Product getProductsById(String productsID) {
        String query = subQuery + " WHERE p.ProductID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, productsID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("SupplierID"),
                        rs.getString("CategoryName"),
                        rs.getString("QuantityPerUnit"),
                        rs.getDouble("UnitPrice"),
                        rs.getString("ProductImage")
                );
            }
        } catch (Exception e) {
            System.out.println("Error get products by product id in DAO " + e.getMessage());
        }
        return null;
    }

    public void createProducts(String ProductName, int supplierID, int categoryID, String quantityPerUnit, double unitPrice, String productImage) {
        String query = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, ProductName);
            ps.setInt(2, supplierID);
            ps.setInt(3, categoryID);
            ps.setString(4, quantityPerUnit);
            ps.setDouble(5, unitPrice);
            ps.setString(6, productImage);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error create product in DAO " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        String query = "DELETE FROM Products\n"
                + "WHERE ProductID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete products in DAO " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ProductDAO p = new ProductDAO(); 
        List<Product> list = p.getLoadMoreProduct(3); 
        for (Product o : list) {
            System.out.println(o);
        }
    }
}
