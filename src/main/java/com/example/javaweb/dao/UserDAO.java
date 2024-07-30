package com.example.javaweb.dao;

import com.example.javaweb.database.ConnectDB;
import com.example.javaweb.models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    public static ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            users.add(new User(username, password));
        }
        return users;
    }
    public static User getUser(String username) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM users WHERE username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user=new User(rs.getString("username"), rs.getString("password"));
        }
        return user;
    }

    public static boolean save(User user) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Connection con = ConnectDB.connect();
        String sql = "INSERT INTO users VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        if (ps.executeUpdate() == 1) {
            status = true;
        }
        con.close();
        return status;
    }

    public static boolean update(User user,String old_name) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Connection con = ConnectDB.connect();
        String sql = "UPDATE users SET username=?, password=? WHERE username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, old_name);
        if (ps.executeUpdate() == 1) {
            status = true;
        }
        con.close();
        return status;
    }

    public static boolean remove(String username) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Connection con = ConnectDB.connect();
        String sql = "DELETE  FROM users WHERE username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        if (ps.executeUpdate() == 1) {
            status = true;
        }
        con.close();
        return status;
    }
}
