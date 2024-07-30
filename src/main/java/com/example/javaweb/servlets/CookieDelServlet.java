package com.example.javaweb.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDelServlet", value = "/cookie-del")
public class CookieDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie cookie=new Cookie("user","");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
    response.getWriter().println("Cookie deleted successfully");
    }
}
