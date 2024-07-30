package com.example.javaweb;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class MyApp {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java56","root","");
//            System.out.println("server connected successfully");
            String sql="SELECT * FROM users";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("username")+" "+rs.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
}
