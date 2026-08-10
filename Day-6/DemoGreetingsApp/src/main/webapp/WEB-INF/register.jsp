<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

<h2>User Registration</h2>

<form action="/register" method="post">

    Name :
    <input type="text" name="name" required>
    <br><br>

    Email :
    <input type="email" name="email" required>
    <br><br>

    Password :
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Register</button>

</form>

<br>

<a href="/login">Already have an account?</a>

</body>
</html>