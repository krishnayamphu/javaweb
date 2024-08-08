package com.example.javaweb;

import com.example.javaweb.dao.ProductDAO;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class MyApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(ProductDAO.getProductsCount("s"));
    }
}
