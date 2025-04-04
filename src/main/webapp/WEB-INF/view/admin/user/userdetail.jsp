<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail ${detailUser.id}</title>

                <!--Compile CSS-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <!--Compile JS-->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <!--Compile JQUERY-->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-12 mx-auto">
                            <div class="d-flex justify-content-between">
                                <h3>User Detail with id = ${id}</h3>
                            </div>
                            <div class="card" style="width: 60%;">
                                <div class="card-header">
                                    Detail with user ${id}
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">ID: ${detailUser.id}</li>
                                    <li class="list-group-item">Email: ${detailUser.email}</li>
                                    <li class="list-group-item">FullName: ${detailUser.fullName}</li>
                                    <li class="list-group-item">Address: ${detailUser.address}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </body>

            </html>