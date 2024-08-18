package com.example.javaweb.controllers;

import com.example.javaweb.dao.CategoryDAO;
import com.example.javaweb.dao.ProductDAO;
import com.example.javaweb.events.MyProgressListener;
import com.example.javaweb.models.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductAddController", value = "/product-add")
public class ProductAddController extends HttpServlet {
    private String name;
    private double price;
    private String img;
    private int category_id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("categories", CategoryDAO.getCategories());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("products/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); // Or "javax.servlet.context.tempdir" for javax
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                for (Iterator<FileItem> it = items.iterator(); it.hasNext(); ) {
                    FileItem item = it.next();
                    if (item.isFormField()) {
                        processFormField(item);
                    } else {
                        String rootPath = getServletContext().getRealPath("/uploads");
                        processUploadedFile(item, rootPath);
                    }
                }
                ProductDAO.save(new Product(name, price, img, category_id));
//                System.out.println(name);
//                System.out.println(price);
//                System.out.println(img);
//                System.out.println(category_id);
                System.out.println("data saved");
                response.sendRedirect("products");
            } catch (FileUploadException | SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.getWriter().println("error in uploading file.");
        }
    }

    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName()+"=>"+item.isFormField());;
        if (item.getFieldName().equals("name")) {
            name = item.getString();
        }
        if (item.getFieldName().equals("price")) {
            price = Double.parseDouble(item.getString());
        }
        if (item.getFieldName().equals("category")) {
            category_id = Integer.parseInt(item.getString());
        }

    }

    private void processUploadedFile(FileItem item,String rootPath) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        String fileName = item.getName();
        LocalDateTime date= LocalDateTime.now();
        img=fileName;
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
