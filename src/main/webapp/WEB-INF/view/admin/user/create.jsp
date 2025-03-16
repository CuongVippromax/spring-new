<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <!--Compile CSS-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!--Compile JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <!--Compile JQUERY-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
          $(document).ready(() => {
            const avatarFile = $("#avatarFile");
            avatarFile.change(function (e) {
              const imgURL = URL.createObjectURL(e.target.files[0]);
              $("#avatarPreview").attr("src", imgURL);
              $("#avatarPreview").css({ "display": "block" });
            });
          });
        </script>

      </head>

      <body>
        <div>
          <h2>Create a user</h2>
        </div>
        <hr>
        <form:form method="post" action="/admin/user/create" modelAttribute="newUser" class="row"
          enctype="multipart/form-data">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <form:input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
              path="email" />
          </div>


          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <form:input type="password" class="form-control" id="exampleInputPassword1" path="password" />
          </div>


          <div class="form-group">
            <label for="exampleInputPassword1">Phone Number</label>
            <form:input type="text" class="form-control" id="exampleInputPassword1" path="phone" />
          </div>


          <div class="form-group">
            <label for="exampleInputPassword1">FullName</label>
            <form:input type="text" class="form-control" id="exampleInputPassword1" path="fullName" />
          </div>


          <div class="form-group">
            <label for="exampleInputPassword1">Address</label>
            <form:input type="text" class="form-control" id="exampleInputPassword1" path="address" />
          </div>


          <div class="mb-3">
            <label for="avatarFile" class="form-label">Avatar</label>
            <input class="form-control" type="file" id="avatarFile" accept=".png, .jpg, .jpeg" name="cuongFile" />
          </div>


          <div class="col-12 mb-3">
            <img style="max-height : 250px ;display: none;" alt="avatar preview" id="avatarPreview">
          </div>


          <div>
            <label class="form-label">Role</label>
            <form:select class="form-select" path="role.name">
              <form:option value="admin">Admin</form:option>
              <form:option value="user">User</form:option>
            </form:select>
          </div>


          <div><button type="submit" class="btn btn-primary">Create</button></div>
        </form:form>
      </body>

      </html>