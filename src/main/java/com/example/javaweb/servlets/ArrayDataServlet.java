package com.example.javaweb.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArrayDataServlet", value = "/array-data")
public class ArrayDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> list=new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Mango");

        request.setAttribute("list",list);
        request.getRequestDispatcher("jstl/foreach.jsp").forward(request,response);
    }
}
