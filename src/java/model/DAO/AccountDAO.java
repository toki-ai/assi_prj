package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Account;
import service.DBUtils;

public class AccountDAO {
    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public Account getAccountByUsernameAndPassword (String username, String password){
        String query = "select * from Account where Username = ? AND Password = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query); 
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery(); 
            while(rs.next()){
                return new Account(
                        rs.getInt("AccountID"), 
                        rs.getString("UserName"), 
                        rs.getString("Password"),
                        rs.getString("FullName"), 
                        rs.getInt("Type")
                );
            }
        } catch (Exception e) {
            System.out.println("Error in get acc by username and password " + e.getMessage());
        }
        return null; 
    }
    
    public Account checkAccountExit (String username){
        String query = "select * from Account where Username = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query); 
            ps.setString(1, username);
            rs = ps.executeQuery(); 
            while(rs.next()){
                return new Account(
                        rs.getInt("AccountID"), 
                        rs.getString("UserName"), 
                        rs.getString("Password"),
                        rs.getString("FullName"), 
                        rs.getInt("Type")
                );
            }
        } catch (Exception e) {
            System.out.println("Error in check account exits " + e.getMessage());
        }
        return null; 
    }
    
    public void createAccount (String username, String password, String fullname){
        String query = "INSERT INTO Account (UserName, Password, FullName, Type) VALUES\n" +
                    "(?, ?, ?, 2)"; 
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query); 
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.executeUpdate(); 
        } catch (Exception e) {
            System.out.println("Error in create account " + e.getMessage());
        }
    }
}
