package com.example.javaweb.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieSetServlet", value = "/cookie-set")
public class CookieSetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("user","Admin");
        cookie.setMaxAge(60*60); //expired in 1 hour
        response.addCookie(cookie);
        response.getWriter().println("cookie set successfully");
    }
}
