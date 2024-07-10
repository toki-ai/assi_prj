/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.entity.Order;
import model.entity.OrderDetail;
import utils.DBUtils;

public class OrderDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM Orders order by OrderDate DESC";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
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
            System.out.println("Error get all order in DAO " + e.getMessage());
        }
        return list;
    }
    
    public List<Order> getOrderByUserID(int id) {
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

    public Order getOrderByID(String id) {
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

    public List<OrderDetail> getOrderDetailOrderID(String id) {
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

    public void deleteOrderDetail(String id) {
        String query = "DELETE FROM OrderDetails\n"
                + "WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error get order detail by order id in DAO " + e.getMessage());
        }
    }

    public void deleteOrder(String id) {
        String query = "DELETE FROM Orders\n"
                + "WHERE OrderID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error get order detail by order id in DAO " + e.getMessage());
        }
    }

    public int createOrder(int customerID, Date orderDate, Date requiredDate, Date shippedDate, double freight, String shipAddress) {
        String query = "INSERT INTO Orders (CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES\n"
                + "(?, ?, ?, ?, ?, ?)";
        int orderId = 0;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            java.sql.Date sqlOrderDate = new java.sql.Date(orderDate.getTime());
            java.sql.Date sqlRequiredDate = new java.sql.Date(requiredDate.getTime());
            java.sql.Date sqlShippedDate = new java.sql.Date(shippedDate.getTime());

            ps.setInt(1, customerID);
            ps.setDate(2, sqlOrderDate);
            ps.setDate(3, sqlRequiredDate);
            ps.setDate(4, sqlShippedDate);
            ps.setDouble(5, freight);
            ps.setString(6, shipAddress);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("Insertion failed, no rows affected.");
                return 0;
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                } else {
                    System.out.println("Failed to retrieve generated keys after insertion.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error inset order in DAO " + e.getMessage());
        }
        return orderId;
    }

    public void createOrderDetail(int orderID, int productID, double unitPrice, int quantity) {
        String query = "INSERT INTO OrderDetails (OrderID, ProductID, UnitPrice, Quantity) VALUES\n"
                + "(?, ?, ?, ?)";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setDouble(3, unitPrice);
            ps.setInt(4, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error insert orderDetail in DAO " + e.getMessage());
        }
    }
    
    public void updateOrder(){
        String query = "INSERT INTO OrderDetails (OrderID, ProductID, UnitPrice, Quantity) VALUES\n"
                + "(?, ?, ?, ?)";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
//            ps.setInt(1, orderID);
//            ps.setInt(2, productID);
//            ps.setDouble(3, unitPrice);
//            ps.setInt(4, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error insert orderDetail in DAO " + e.getMessage());
        }
    }
}
