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
import model.entity.Currency;
import utils.DBUtils;

public class CurrencyDAO {

    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Currency> getCurrencyBySearch(String code, String name) {
        List<Currency> list = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from tblCurrency WHERE 1=1");

        if (code != null && !code.isEmpty()) {
            query.append(" AND code LIKE ?");
        }
        if (name != null && !name.isEmpty()) {
            query.append(" AND [name] LIKE ?");
        }

        try {
            cn = new DBUtils().getConnection();
            ps = cn.prepareStatement(query.toString());

            int paramIndex = 1;
            if (code != null && !code.isEmpty()) {
                ps.setString(paramIndex++, "%" + code + "%");
            }
            if (name != null && !name.isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
            }
//        try {
//            cn = new DBUtils().getConnection();
//            ps = cn.prepareStatement(query);
//            ps.setString(1, "%" + code + "%");
//            ps.setString(2, "%" + name + "%"); 
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Currency(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        CurrencyDAO c = new CurrencyDAO();
        List<Currency> list = c.getCurrencyBySearch("", "A");
        for (Currency o : list) {
            System.out.println(o);
        }
    }
}
