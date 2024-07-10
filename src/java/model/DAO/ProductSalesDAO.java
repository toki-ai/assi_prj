package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.ProductSales;
import utils.DBUtils;

public class ProductSalesDAO {
    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ProductSales> getProductSalesByDate (Date startDate, Date endDate){
        String query = "SELECT P.ProductID, P.ProductName, SUM(OD.Quantity * OD.UnitPrice) AS TotalPriceSold " +
                       "FROM OrderDetails OD " +
                       "JOIN Orders O ON OD.OrderID = O.OrderID " +
                       "JOIN Products P ON OD.ProductID = P.ProductID " +
                       "WHERE O.OrderDate BETWEEN ? AND ? " +
                       "GROUP BY P.ProductID, P.ProductName " +
                       "ORDER BY TotalPriceSold DESC";
        
        List<ProductSales> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductSales(
                        rs.getInt("ProductID"), 
                        rs.getString("ProductName"), 
                        rs.getDouble("TotalPriceSold")
                ));      
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error in get acc by username and password " + e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        Date a = java.sql.Date.valueOf("2024-07-01");
        Date b = java.sql.Date.valueOf("2024-07-10");
        ProductSalesDAO p = new ProductSalesDAO();
        List<ProductSales> list = p.getProductSalesByDate(a, b);
        for (ProductSales o : list) {
            System.out.println(o);
        }
    }
}
