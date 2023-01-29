<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Akela
  Date: 26/01/2023
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" href="#">Navbar w/ text</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarText">
<ul class="navbar-nav mr-auto">
<li class="nav-item active">
    <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
</li>

<%--      Condition d'affichage de navbar différente selon l'utilisateur--%>
<c:choose>
    <c:when test="${not empty sessionScope.username}">
          <span class="navbar-text">
      Username <form method="post" action="/logout" type="submit"> <button class="btn btn-sm btn-outline-secondary">  Déconnexion </button> </form>
    </span>
        <c:choose>
            <c:when test="${sessionScope.superadmin == true}">

                <li class="nav-item">
                    <a class="nav-link" href="/add-admin"> Create admin</a>
                </li>

            </c:when>
        </c:choose>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${empty sessionScope.username}">
        <li class="nav-item">
        <a class="nav-link" href="/login">Connexion</a>
        </li>
    </c:when>
</c:choose>
        <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
        </li>
        </ul>
        </div>
        </nav>

