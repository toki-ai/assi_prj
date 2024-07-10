package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.Category;
import utils.DBUtils;

public class CategoryDAO {
    Connection cnn = null; 
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM Categories" ;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"),
                        rs.getString("Description")
                ));
            }   
        } catch (Exception e) {
            System.out.println("Error get all category in DAO" + e.getMessage());
        } 
        return list;
    }
    
    public int getIDCategoryByName(String name){
        int id;
        String query = "SELECT * FROM Categories WHERE CategoryName = ?" ;
        try {
            cnn = new DBUtils().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("CategoryID");
            }   
        } catch (Exception e) {
            System.out.println("Error get id category  by name in DAO " + e.getMessage());
        } 
        return 0;
    }
}
