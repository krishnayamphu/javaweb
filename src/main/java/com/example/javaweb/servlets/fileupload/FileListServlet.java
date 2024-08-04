package com.example.javaweb.servlets.fileupload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileListServlet", value = "/files")
public class FileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String rootPath=getServletContext().getRealPath("/uploads");
        File f=new File(rootPath);
        File[] files=f.listFiles();
        for(File item:files){
            response.getWriter().println("<img src='uploads/"+item.getName()+"' width='100'>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
