package com.example.javaweb.servlets.fileupload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FileListServlet", value = "/files")
public class FileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String rootPath=getServletContext().getRealPath("/uploads");
        File f=new File(rootPath);
        File[] files=f.listFiles();
        ArrayList<String> items=new ArrayList<>();
        if(files!=null){
            for(File item:files){
                items.add(item.getName());
            }
        }
        request.setAttribute("items",items);
        request.getRequestDispatcher("fileupload/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=request.getParameter("image");
        String rootPath=getServletContext().getRealPath("/uploads");
        File f=new File(rootPath+"/"+filename);
        if(f.delete()){
            System.out.println("file deleted");
        }
        response.sendRedirect("files");
    }
}
