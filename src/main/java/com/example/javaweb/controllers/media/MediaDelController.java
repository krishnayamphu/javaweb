package com.example.javaweb.controllers.media;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "MediaDelController", value = "/media-del")
public class MediaDelController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("image");
        String rootPath=getServletContext().getRealPath("/uploads");
        File f=new File(rootPath+"/"+name);
        f.delete();
        response.sendRedirect("media");
    }
}
