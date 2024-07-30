package com.example.javaweb.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "UserServlet", value = "/all-users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java56","root","");
            String sql="SELECT * FROM users";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            pw.print("<table border='1'>");
            pw.print("<tr>" +
                    "<th>Username</th>" +
                    "<th>Password</th>" +
                    "</tr>");
            while (rs.next()){
                String username=rs.getString("username");
                String password=rs.getString("password");
                pw.print("<tr>" +
                        "<td>"+username+"</td>" +
                        "<td>"+password+"</td>" +
                        "</tr>");
            }
            pw.print("</table>");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }


}
