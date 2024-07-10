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
import model.entity.Supplier;
import utils.DBUtils;

/**
 *
 * @author toki
 */
public class SupplierDAO {
    Connection cnn = null; 
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public List<Supplier> getAllSupplier(){
        List<Supplier> list = new ArrayList<>();
        String query = "SELECT * FROM Suppliers" ;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Supplier(
                        rs.getInt("SupplierID"),
                        rs.getString("CompanyName"),
                        rs.getString("Address"),
                        rs.getString("Phone")
                ));
            }   
        } catch (Exception e) {
            System.out.println("Error get all supplier in DAO" + e.getMessage());
        } 
        return list;
    }
}
