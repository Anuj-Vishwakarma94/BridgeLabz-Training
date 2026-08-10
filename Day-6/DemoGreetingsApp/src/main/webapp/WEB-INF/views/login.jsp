<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login — DemoGreetingsApp</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            font-family: 'Inter', sans-serif;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
            background-size: 400% 400%;
            animation: gradientShift 10s ease infinite;
        }

        @keyframes gradientShift {
            0%   { background-position: 0% 50%; }
            50%  { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .card {
            background: rgba(255, 255, 255, 0.08);
            backdrop-filter: blur(20px);
            -webkit-backdrop-filter: blur(20px);
            border: 1px solid rgba(255, 255, 255, 0.15);
            border-radius: 20px;
            padding: 44px 40px;
            width: 100%;
            max-width: 420px;
            box-shadow: 0 25px 50px rgba(0,0,0,0.4);
            animation: slideUp 0.5s ease;
        }

        @keyframes slideUp {
            from { opacity: 0; transform: translateY(30px); }
            to   { opacity: 1; transform: translateY(0); }
        }

        .logo {
            text-align: center;
            margin-bottom: 28px;
        }

        .logo-icon {
            width: 56px;
            height: 56px;
            background: linear-gradient(135deg, #34d399, #10b981);
            border-radius: 16px;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            margin-bottom: 14px;
            box-shadow: 0 8px 20px rgba(16,185,129,0.4);
        }

        h2 {
            color: #ffffff;
            font-size: 1.6rem;
            font-weight: 700;
            text-align: center;
            margin-bottom: 6px;
        }

        .subtitle {
            color: rgba(255,255,255,0.5);
            font-size: 0.85rem;
            text-align: center;
            margin-bottom: 28px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            color: rgba(255,255,255,0.75);
            font-size: 0.8rem;
            font-weight: 500;
            margin-bottom: 6px;
            letter-spacing: 0.03em;
            text-transform: uppercase;
        }

        input {
            width: 100%;
            padding: 12px 16px;
            background: rgba(255,255,255,0.07);
            border: 1px solid rgba(255,255,255,0.12);
            border-radius: 10px;
            color: #ffffff;
            font-size: 0.95rem;
            font-family: 'Inter', sans-serif;
            outline: none;
            transition: border-color 0.25s, background 0.25s, box-shadow 0.25s;
        }

        input::placeholder { color: rgba(255,255,255,0.3); }

        input:focus {
            border-color: #34d399;
            background: rgba(52,211,153,0.08);
            box-shadow: 0 0 0 3px rgba(52,211,153,0.15);
        }

        .btn {
            width: 100%;
            padding: 13px;
            margin-top: 8px;
            background: linear-gradient(135deg, #34d399, #10b981);
            border: none;
            border-radius: 10px;
            color: #ffffff;
            font-size: 1rem;
            font-weight: 600;
            font-family: 'Inter', sans-serif;
            cursor: pointer;
            transition: opacity 0.2s, transform 0.15s, box-shadow 0.2s;
            box-shadow: 0 6px 20px rgba(16,185,129,0.4);
        }

        .btn:hover {
            opacity: 0.9;
            transform: translateY(-1px);
            box-shadow: 0 10px 28px rgba(16,185,129,0.5);
        }

        .btn:active { transform: translateY(0); }

        .footer-link {
            text-align: center;
            margin-top: 22px;
            color: rgba(255,255,255,0.5);
            font-size: 0.875rem;
        }

        .footer-link a {
            color: #34d399;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.2s;
        }

        .footer-link a:hover { color: #6ee7b7; }

        .error-msg {
            background: rgba(239,68,68,0.15);
            border: 1px solid rgba(239,68,68,0.35);
            border-radius: 8px;
            padding: 10px 14px;
            color: #fca5a5;
            font-size: 0.85rem;
            margin-bottom: 18px;
        }
    </style>
</head>
<body>

<div class="card">
    <div class="logo">
        <div class="logo-icon">🔑</div>
    </div>
    <h2>Welcome Back</h2>
    <p class="subtitle">Sign in to continue</p>

    <% if (request.getAttribute("error") != null || request.getParameter("error") != null) { %>
    <div class="error-msg">${error}</div>
    <% } %>

    <form action="/login" method="post">

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" placeholder="you@example.com" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="••••••••" required>
        </div>

        <button type="submit" class="btn">Sign In</button>

    </form>

    <div class="footer-link">
        Don't have an account? <a href="/register">Create one</a>
    </div>
</div>

</body>
</html>
