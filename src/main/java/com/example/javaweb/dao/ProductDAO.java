package com.example.javaweb.dao;

import com.example.javaweb.database.ConnectDB;
import com.example.javaweb.models.Product;
import com.example.javaweb.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    public static ArrayList<Product> getProducts() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT products.id,products.name,price,img,category.name FROM products INNER JOIN category ON products.category_id=category.id";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product=new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setImg(rs.getString("img"));
            product.setCategoryName(rs.getString(5));
            products.add(product);
        }
        return products;
    }
}
