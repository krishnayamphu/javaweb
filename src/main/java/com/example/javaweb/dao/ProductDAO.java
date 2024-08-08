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
    public static ArrayList<Product> getProducts(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM products WHERE name LIKE '"+name+"%'";
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
    public static int getProductsCount(String name) throws SQLException, ClassNotFoundException {
        int count=0;
        Connection con = ConnectDB.connect();
        String sql = "SELECT COUNT(id) FROM products WHERE name LIKE '"+name+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count=rs.getInt(1);
        }
        return count;
    }

    public static boolean save(Product product) throws SQLException {
        boolean status = false;
        Connection con = null;
        try {
            con = ConnectDB.connect();
            String sql = "INSERT INTO products(name,price,category_id,img) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3,product.getCategoryId());
            ps.setString(4, product.getImg());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        con.close();
        return status;
    }
}
