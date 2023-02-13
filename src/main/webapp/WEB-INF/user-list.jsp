<%--
  Created by IntelliJ IDEA.
  User: Akela
  Date: 30/01/2023
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<c:choose>
    <c:when test="${sessionScope.adminBool == true}">
        <h1> Test USER LIST</h1>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Username</th>
                    <th scope="col">Mail</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${users}" var="user">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td>${user.username}</td>
                        <td> none</td>
                        <td>${user.username}</td>
                        <td>${user.mail}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                <!--TODO:
                                Utiliser le bool actif ou pas actif pour afficher soit Activer soit Désactiver
                                (et le lier à une modif en BDD via servlet EnableUserServlet ou DisableUserServlet)
                                -->
                                    <%--                                Si bool actif à 1: affichez ceci et renvoyer la servlet correspondante--%>
                                <a href="/enable-user?idUser=${user.id}">
                                    <button type="button" class="btn btn-warning">Désactiver</button>
                                </a>
                                        <%--                                Si bool actif à 0: affichez ceci et renvoyer la servlet correspondante--%>
                                <a href="/enable-user?idUser=${user.id}">
                                    <button type="button" class="btn btn-warning">Activer</button>
                                </a>
                                    <%--                                Renvoyer à la servlet modifier (update)--%>
                                <a href="/update-user?idUser=${user.id}">
                                    <button type="button" class="btn btn-warning">Modifier</button>
                                </a>
                                <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal${user.id}">
                                    Supprimer
                                </button>
                            </div>


                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal${user.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel${user.id}" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel${user.id}">Voulez vous
                                                vraiment utiliser l'user "${user.username}" </h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Cette action est irréversible et entraînera la suppression de toutes les
                                            données, calendriers etc de l'utilisateur.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Close
                                            </button>
                                            <a href="/del-user?idUser=${user.id}">
                                                <button class="btn btn-primary"> Supprimer quand même</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </td>
                    </tr>


                </c:forEach>

                </tbody>
            </table>
        </div>


    </c:when>
</c:choose>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
