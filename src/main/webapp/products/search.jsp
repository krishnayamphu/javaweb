<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="d-flex justify-content-between py-4 border-bottom-1">
    <h3>Products <small>(${totalProducts})</small></h3>
    <a class="btn btn-outline-secondary" href="products">Products</a>
</div>
    <form action="search">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="name" placeholder="search product">
            <button class="btn btn-outline-secondary" type="submit">Search</button>
        </div>
    </form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#ID</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Category</th>
            <th scope="col">Image</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.categoryName}</td>
                <td>
                    <img style="width: 50px" src="uploads/${product.img}" alt="">
                </td>
                <td>
                    <a class="btn btn-primary"  href="#">Edit</a>
                    <a class="btn btn-danger ms-2" href="#">Remove</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>