<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>User Login</h2>

<form action="/login" method="post">

    Email :
    <input type="email" name="email" required>
    <br><br>

    Password :
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Login</button>

</form>

<br>

<p style="color:red">${error}</p>

<a href="/register">Create New Account</a>

</body>
</html>