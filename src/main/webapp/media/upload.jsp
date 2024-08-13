<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Upload Media</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-6">
      <form action="media" method="post" enctype="multipart/form-data">
        <div class="input-group mb-3">
          <input type="file" class="form-control" name="upfile" placeholder="choose a file">
          <button class="btn btn-outline-secondary" type="submit">Upload</button>
        </div>
      </form>
    </div>
  </div>

  <div class="row row-cols-1 row-cols-lg-6 my-4">
    <c:forEach items="${items}" var="item">
      <div class="col">
        <div class="card">
          <img src="uploads/${item}" alt="" class="w-100">
          <div class="d-flex p-2">
            <a class="btn btn-success me-2" href="uploads/${item}">View</a>
            <form action="media" class="m-0">
              <input type="hidden" name="${item}" value="${item}">
              <button class="btn btn-danger">Remove</button>
            </form>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
