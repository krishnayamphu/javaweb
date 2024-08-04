package com.example.javaweb.servlets.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet", value = "/file-upload")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("fileupload/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); // Or "javax.servlet.context.tempdir" for javax
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            try {
                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                for (Iterator<FileItem> it = items.iterator(); it.hasNext(); ) {
                    FileItem item = it.next();
                    if (item.isFormField()) {
                        //processFormField(item);
                    } else {
                        String rootPath=getServletContext().getRealPath("/uploads");
                        processUploadedFile(item,rootPath);
                        response.sendRedirect("file-upload");
                    }
                }

            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }


        }else{
            System.out.println("sorry, no file upload are made");
        }
    }

    private void processUploadedFile(FileItem item,String rootPath) {
        String fileName = item.getName();
        File path = new File(rootPath);
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            item.write(uploadedFile);
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
