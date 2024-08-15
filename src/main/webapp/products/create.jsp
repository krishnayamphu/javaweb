<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="d-flex justify-content-between py-4 border-bottom-1">
    <h3>Add Product</h3>
    <a class="btn btn-outline-secondary" href="products">All Products</a>
</div>

    <form action="product-add" method="post" enctype="multipart/form-data">
        <input class="form-control mb-4" type="text" name="name" placeholder="Product Name" required>
        <input class="form-control mb-4" type="number" name="price" placeholder="Price" required>

        <select class="form-control mb-4" name="category" id="">
            <option value="">Select Category</option>
            <c:forEach items="${categories}" var="item">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
<%--        <input class="form-control mb-4" type="text" placeholder="Product Image" name="image" value="default.jpg">--%>

        <div class="input-group mb-3">
            <input type="file" class="form-control" name="upfile" placeholder="choose a file">
            <button class="btn btn-outline-secondary" type="submit">Upload</button>
        </div>

        <button class="btn btn-success">Submit</button>
    </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>