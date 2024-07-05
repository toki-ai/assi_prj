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
import service.DBUtils;

/**
 *
 * @author toki
 */
public class OrderDAO {
    Connection cnn = null; 
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public List<Order> getOrderByUserID (String id){
        List<Order> list = new ArrayList<>();
        String query = "";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("customerID"),
                        rs.getDate("orderDate"),
                        rs.getDate("requiredDate"),
                        rs.getDate("shippedDate"),
                        rs.getDouble("freight"),
                        rs.getString("shipAddress")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error get order by user id in DAO " + e.getMessage());
        }
        return list;
    }
}
