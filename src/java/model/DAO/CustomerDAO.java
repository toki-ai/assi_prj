package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.Customer;
import utils.DBUtils;

public class CustomerDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createAccount(String password, String contactName, String address, String phone) {
        String query = "INSERT INTO Customers (Password, ContactName, Address, Phone) VALUES\n"
                + "(?, ?, ?, ?)";
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

    public Customer getCustomerInforByName(String contactName) {
        String query = "select * from Customers Where ContactName = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, contactName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Password"),
                        rs.getString("ContactName"),
                        rs.getString("Address"),
                        rs.getString("Phone")
                );
            }
        } catch (Exception e) {
            System.out.println("Error get order by order id in DAO " + e.getMessage());
        }
        return null;
    }
    
    public List<Customer> getCustomerByName(String param) {
        String query = "select * from Customers WHERE ContactName LIKE ?";
        List<Customer> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + param + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Password"),
                        rs.getString("ContactName"),
                        rs.getString("Address"),
                        rs.getString("Phone")
                ));
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error in get acc by username and password " + e.getMessage());
        }
        return null;
    }
    
    public List<Customer> getAllCustomer() {
        String query = "select * from Customers";
        List<Customer> list = new ArrayList<>();
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Password"),
                        rs.getString("ContactName"),
                        rs.getString("Address"),
                        rs.getString("Phone")
                ));
            }
            return list; 
        } catch (Exception e) {
            System.out.println("Error in get all customer " + e.getMessage());
        }
        return null;
    }

    public void updateCustomerInfor(String customerID, String newPassword, String newContactName, String newAddress, String newPhone) {
        String query = "UPDATE Customers SET Password = ?, ContactName = ?, Address = ?, Phone = ? WHERE CustomerID = ?";
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, newContactName);
            ps.setString(3, newAddress);
            ps.setString(4, "555-" + newPhone);
            ps.setString(5, customerID);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer information updated successfully.");
            } else {
                System.out.println("Customer not found or no information was updated.");
            }
        } catch (Exception e) {
            System.out.println("Error updating customer information: " + e.getMessage());
        }
    }
}
