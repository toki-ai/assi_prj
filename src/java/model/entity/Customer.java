/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author toki
 */
public class Customer {
    private int customerID;
    private String password;
    private String contactName; 
    private String address; 
    private String phone;

    public Customer() {
    }

    public Customer(int customerID, String password, String contactName, String address, String phone) {
        this.customerID = customerID;
        this.password = password;
        this.contactName = contactName;
        this.address = address;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", password=" + password + ", contactName=" + contactName + ", address=" + address + ", phone=" + phone + '}';
    }
    
}
