<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {
            background: #000;
            color: #fff;
            font-family: sans-serif;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            width: 320px;
            text-align: center;
        }

        h2 {
            font-size: 1.6rem;
            font-weight: 600;
            margin-bottom: 28px;
        }

        .form-group {
            margin-bottom: 14px;
            text-align: left;
        }

        label {
            display: block;
            font-size: 0.85rem;
            color: #aaa;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 10px 12px;
            background: #111;
            border: 1px solid #333;
            border-radius: 6px;
            color: #fff;
            font-size: 0.95rem;
            outline: none;
        }

        input:focus { border-color: #fff; }

        .error {
            color: #f87171;
            font-size: 0.85rem;
            margin-bottom: 14px;
        }

        button {
            width: 100%;
            padding: 11px;
            margin-top: 8px;
            background: #fff;
            color: #000;
            border: none;
            border-radius: 6px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.2s;
        }

        button:hover { background: #ddd; }

        .footer {
            margin-top: 20px;
            font-size: 0.85rem;
            color: #666;
        }

        .footer a { color: #fff; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>

        <% if (request.getAttribute("error") != null) { %>
        <p class="error">${error}</p>
        <% } %>

        <form action="/login" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="you@example.com" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required>
            </div>
            <button type="submit">Sign In</button>
        </form>

        <p class="footer">No account? <a href="/register">Register</a></p>
    </div>
</body>
</html>
