package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import service.DBUtils;

public class CustomerDAO {
    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public void createAccount (String password, String contactName, String address, String phone){
        String query = "INSERT INTO Customers (Password, ContactName, Address, Phone) VALUES\n" +
                    "(?, ?, ?, ?)"; 
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query); 
            ps.setString(1, password);
            ps.setString(2, contactName);
            ps.setString(3, address);
            ps.setString(4, "555-" + phone);
            ps.executeUpdate(); 
        } catch (Exception e) {
            System.out.println("Error in create customer " + e.getMessage());
        }
    }
}
