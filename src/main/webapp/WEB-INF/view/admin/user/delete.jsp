<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete Users</title>

                <!--Compile CSS-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <!--Compile JS-->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <!--Compile JQUERY-->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            </head>

            <body>
                <div>Delete the user with id = ${id}</div>
                <hr>
                <div class="alert alert-danger" role="alert">
                    Are you sure to delete this user ?
                </div>
                <form:form method="post" action="/admin/user/delete" modelAttribute="newUser">
                    <div class="form-group" style="display: none;">
                        <label for="exampleInputPassword1">ID</label>
                        <form:input type="text" class="form-control" path="id" />
                    </div>
                    <button class="btn btn-danger">Confirm</button>
                </form:form>

            </body>

            </html>