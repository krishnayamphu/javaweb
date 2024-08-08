package com.example.javaweb.controllers;

import com.example.javaweb.dao.CategoryDAO;
import com.example.javaweb.dao.ProductDAO;
import com.example.javaweb.models.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductAddController", value = "/product-add")
public class ProductAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("categories", CategoryDAO.getCategories());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("products/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        String img=request.getParameter("image");
        int category_id =Integer.parseInt(request.getParameter("category"));
        try {
            ProductDAO.save(new Product(name,price,img,category_id));
            response.sendRedirect("products");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
