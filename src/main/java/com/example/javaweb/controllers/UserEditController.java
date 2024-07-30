package com.example.javaweb.controllers;

import com.example.javaweb.dao.UserDAO;
import com.example.javaweb.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserEditController", value = "/user-edit")
public class UserEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        try {
            User user= UserDAO.getUser(username);
            request.setAttribute("user",user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old_name=request.getParameter("old_name");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try {
            UserDAO.update(new User(username,password),old_name);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("users");
    }
}
