<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Media Files</title>
    <style>
        *{
            font-family: Arial;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .media-container{
            width: 90%;
            margin: 15px auto;
            border: 1px solid #ccc;
            display: flex;
            flex-wrap: wrap;
        }
        .card{
            width: 25%;
            margin: 15px;
            border: 1px solid #cccccc;
        }
        .card img{
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        #modal{
            display: none;
            justify-content: center;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.7);
            width: 100%;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
        }
        .modal-content{
            background-color: white;
            width: 300px;
            padding: 15px;
        }
        .action{
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px 15px;
        }
        form{
            display: flex;
            justify-content: center;
            margin-left: 10px;

        }

    </style>
</head>
<body>

<div class="media-container">
    <c:choose>
        <c:when test="${items!=null}">
            <c:forEach items="${items}" var="item">
                <div class="card">
                    <img src="uploads/${item}" alt="">
                    <button onclick="showDialog()">
                        Delete
                    </button>
                   <div id="modal">

                      <div class="modal-content">
                          <p>Are you sure delete this item?</p>
                          <div class="action">
                              <button onclick="closeDialog()">Cancel</button>
                              <form action="files" method="post">
                                  <input type="hidden" name="image" value="${item}">
                                  <button>Confirm</button>
                              </form>
                          </div>

                      </div>
                   </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>No files</p>
        </c:otherwise>
    </c:choose>

</div>


<script>
    function showDialog(){
        document.getElementById("modal").style.display="flex";
    }
    function closeDialog(){
        document.getElementById("modal").style.display="none";
    }
</script>
</body>
</html>
