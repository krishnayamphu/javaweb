package com.example.javaweb.controllers.media;

import com.example.javaweb.events.MyProgressListener;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "MediaController", value = "/media")
public class MediaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getRequestDispatcher("media/upload.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //	public static final long MAX_UPLOAD_IN_MEGS = 50;
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
//            upload.setSizeMax(MAX_UPLOAD_IN_MEGS * 1024 * 1024);

            MyProgressListener progressListener = new MyProgressListener();
            upload.setProgressListener(progressListener);

            HttpSession session = request.getSession();
            session.setAttribute("progressListener", progressListener);
            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                for (Iterator<FileItem> it = items.iterator(); it.hasNext(); ) {
                    FileItem item = it.next();
                    if (item.isFormField()) {
                        //processFormField(item);
                        //regular form input e.g. email,password
                    } else {
//                        String fieldName = item.getFieldName();
//                        String fileName = item.getName();
//                        String contentType = item.getContentType();
//                        boolean isInMemory = item.isInMemory();
//                        long sizeInBytes = item.getSize();
//
//                        System.out.println(fieldName);
//                        System.out.println(fileName);
//                        System.out.println(contentType);
//                        System.out.println(isInMemory);
//                        System.out.println(sizeInBytes);

                        String rootPath=getServletContext().getRealPath("/uploads");
                        processUploadedFile(item,rootPath);
                        response.sendRedirect("media");
                    }
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }

        }else{
            response.getWriter().println("error in uploading file.");
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
