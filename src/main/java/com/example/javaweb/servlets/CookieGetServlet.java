package com.example.javaweb.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieGetServlet", value = "/cookie-get")
public class CookieGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Cookie[] cookies=request.getCookies();
            for (Cookie ck:cookies){
                response.getWriter().println(ck.getName()+ "="+ ck.getValue());
            }

    }
}
