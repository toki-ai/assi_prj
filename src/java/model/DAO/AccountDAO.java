package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.Account;
import utils.DBUtils;

public class AccountDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Account> getAllAccountCustomer() {
        String query = "select * from Account WHERE Type = 2";
        List<Account> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("AccountID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getInt("Type")
                ));
            }
            return list; 
        } catch (Exception e) {
            System.out.println("Error in get all acc " + e.getMessage());
        }
        return null;
    }
    
    public List<Account> getAllAccountStaff() {
        String query = "select * from Account WHERE Type = 1";
        List<Account> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("AccountID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getInt("Type")
                ));
            }
            return list; 
        } catch (Exception e) {
            System.out.println("Error in get all acc " + e.getMessage());
        }
        return null;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        String query = "select * from Account where Username = ? AND Password = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    
    public List<Account> getAccountByNameOrID(String param) {
        String query = "select * from Account WHERE UserName LIKE ? OR AccountID LIKE ?";
        List<Account> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + param + "%");
            ps.setString(2, param);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("AccountID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getInt("Type")
                ));
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error in get acc by username and password " + e.getMessage());
        }
        return null;
    }

    public Account checkAccountExit(String username) {
        String query = "select * from Account where Username = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public void createAccount(String username, String password, String fullname) {
        String query = "INSERT INTO Account (UserName, Password, FullName, Type) VALUES\n"
                + "(?, ?, ?, 2)";
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

    public void updateAccountInfo(String accountID, String newUserName, String newPassword, String newFullName, int newType) {
        String query = "UPDATE Account SET UserName = ?, Password = ?, FullName = ?, Type = ? WHERE AccountID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, newUserName);
            ps.setString(2, newPassword);
            ps.setString(3, newFullName);
            ps.setInt(4, newType);
            ps.setString(5, accountID);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Account information updated successfully.");
            } else {
                System.out.println("Account not found or no information was updated.");
            }
        } catch (Exception e) {
            System.out.println("Error updating account information: " + e.getMessage());
        }
    }
}
