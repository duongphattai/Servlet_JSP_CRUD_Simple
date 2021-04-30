<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="utils.PathConst" %>   
<%@ page import="utils.UrlConst" %>
<!doctype html>
<html lang="en">

<head>
    <title>Add user</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/	bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div>
            <h1 class="text-center text-primary p-4">ADD USER PAGE</h1>
        </div>
        <div>
            <h4 class="text-danger">${errMsg }</h4>
        </div>
        <form action="<%= request.getContextPath() + UrlConst.USER_ADD %>" method="post">
        <div class="form-group">
            <label for="">Full name</label>
            <input type="text" name="fullName" value="${curUser.fullName }" id="" class="form-control" placeholder="" aria-describedby="helpId">
        </div>
        <div class="form-group">
            <label for="">Birth year</label>
            <input type="number" name="birthYear" value="${curUser.birthYear }" id="" class="form-control" placeholder="" aria-describedby="helpId">
        </div>
        <div class="form-group">
            <label for="">Username</label>
            <input type="text" name="username" value="${curUser.username }" id="" class="form-control" placeholder="" aria-describedby="helpId">
        </div>
        <div class="form-group">
            <label for="">Password</label>
            <input type="password" name="password" value="${curUser.password }" id="" class="form-control" placeholder="" aria-describedby="helpId">
        </div>
        <div class="form-group">
            <label for="">Role</label>
            <select class="form-control" name="role" id="">
                <option value="0">Director</option>
                <option value="1">Manager</option>
                <option value="2">Staff</option>
            </select>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
        </form>
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