package com.example.javaweb.dao;

import com.example.javaweb.database.ConnectDB;
import com.example.javaweb.models.Category;
import com.example.javaweb.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
    public static ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException {
        ArrayList<Category> categories = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT  * FROM category";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            categories.add((new Category(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("created_at")
            )));
        }
        return categories;
    }
}
