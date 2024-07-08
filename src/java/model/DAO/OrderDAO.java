/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.Order;
import model.entity.OrderDetail;
import utils.DBUtils;

/**
 *
 * @author toki
 */
public class OrderDAO {
    Connection cnn = null; 
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public List<Order> getOrderByUserID (int id){
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE CustomerID = ? order by OrderDate DESC";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("CustomerID"),
                        rs.getDate("OrderDate"),
                        rs.getDate("RequiredDate"),
                        rs.getDate("ShippedDate"),
                        rs.getDouble("Freight"),
                        rs.getString("ShipAddress")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get order by user id in DAO " + e.getMessage());
        }
        return list;
    }
    
    public Order getOrderByID (String id){
        String query = "SELECT * FROM Orders WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("CustomerID"),
                        rs.getDate("OrderDate"),
                        rs.getDate("RequiredDate"),
                        rs.getDate("ShippedDate"),
                        rs.getDouble("Freight"),
                        rs.getString("ShipAddress")
                );
            }
        } catch (Exception e) {
            System.out.println("Error get order by order id in DAO " + e.getMessage());
        }
        return null;
    }
    
    public List<OrderDetail> getOrderDetailOrderID (String id){
        List<OrderDetail> list = new ArrayList<>();
        String query = "select d.*, p.ProductName from OrderDetails d join Products p ON d.ProductID = p.ProductID  WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(
                        rs.getInt("OrderID"),
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("UnitPrice"),
                        rs.getInt("Quantity")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get order detail by order id in DAO " + e.getMessage());
        }
        return list;
    }
    
    public void deleteOrderDetail (String id){
        String query = "DELETE FROM OrderDetails\n" +
                        "WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error get order detail by order id in DAO " + e.getMessage());
        } 
    }
    
    public void deleteOrder (String id){
        String query = "DELETE FROM Orders\n" +
                        "WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error get order detail by order id in DAO " + e.getMessage());
        } 
    }
}
