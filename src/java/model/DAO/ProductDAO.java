package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entity.Product;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import service.DBUtils;

public class ProductDAO {
    Connection cnn = null; 
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public List<Product> getAllProducts(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.ProductID, p.ProductName, p.SupplierID, c.CategoryName, p.QuantityPerUnit, p.UnitPrice, p.ProductImage FROM dbo.Products p JOIN dbo.Categories c ON p.CategoryID = c.CategoryID" ;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
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
            System.out.println("Error get all products in DAO" + e.getMessage());
        } 
        return list;
    }
}
