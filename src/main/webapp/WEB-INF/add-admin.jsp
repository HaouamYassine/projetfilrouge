<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Akela
  Date: 27/01/2023
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Akela
  Date: 27/01/2023
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add admin</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<c:choose>
<c:when test="${sessionScope.superadmin == true}">
<section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Create admin</p>

                <form method="post" action="/add-admin" class="mx-1 mx-md-4">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input name="username" type="text" id="username" class="form-control" />
                      <label  class="form-label" for="username">Username</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input name="email" type="email" id="email" class="form-control" />
                      <label class="form-label" for="email">Email</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input name="password" type="password" id="password" class="form-control" />
                      <label class="form-label" for="password">Password</label>
                    </div>
                  </div>

<%--                  <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>--%>
<%--                    <div class="form-outline flex-fill mb-0">--%>
<%--                      <input type="password" id="form3Example4cd" class="form-control" />--%>
<%--                      <label class="form-label" for="form3Example4cd">Repeat your password</label>--%>
<%--                    </div>--%>
<%--                  </div>--%>

<%--                  <div class="form-check d-flex justify-content-center mb-5">--%>
<%--                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />--%>
<%--                    <label class="form-check-label" for="form2Example3c">--%>
<%--                      I agree all statements in <a href="#!">Terms of service</a>--%>
<%--                    </label>--%>
<%--                  </div>--%>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Register</button>
                  </div>

                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                     class="img-fluid" alt="Sample image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</c:when>
</c:choose>
</body>
</html>