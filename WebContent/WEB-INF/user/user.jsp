<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="utils.PathConst" %>   
<%@ page import="utils.UrlConst" %>   
<!doctype html>
<html lang="en">

<head>
    <title>User Dashboard</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="text-center text-primary p-4">
            <h1>USER DASHBOARD</h1>
        </div>
        <div class="p-2">
            <a href="<c:url value="${UrlConst.USER_ADD }"/>" class="btn btn-primary">Add user</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Full name</th>
                    <th>Birth year</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Function</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="curUser" items="${userList }">
                <tr>
                    <td>${curUser.fullName }</td>
                    <td>${curUser.birthYear }</td>
                    <td>${curUser.username }</td>
                    <td>
                    	<c:if test="${curUser.role == 0 }">Director</c:if>
                    	<c:if test="${curUser.role == 1 }">Manager</c:if>
                    	<c:if test="${curUser.role == 2 }">Staff</c:if>
                    </td>
                    <td>
                        <a href="<c:url value="${UrlConst.USER_EDIT }?username=${curUser.username} "/>" class="btn btn-primary">Edit</a>
                        <a href="<c:url value="${UrlConst.USER_DELETE }?username=${curUser.username} "/>" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
        	<c:if test="${userList.size() == 0 }">
            	<h3 class="text-center text-danger">List empty</h3>
        	</c:if>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
