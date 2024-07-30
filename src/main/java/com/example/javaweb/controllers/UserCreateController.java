package com.example.javaweb.controllers;

import com.example.javaweb.dao.UserDAO;
import com.example.javaweb.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UserCreateController", value = "/user-create")
public class UserCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("users/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user =new User(username,password);
        try {
            if(UserDAO.save(user))
                System.out.println("data inserted");
            response.sendRedirect("users");
        } catch (ClassNotFoundException | SQLException e) {
          throw new RuntimeException();
        }
    }
}
