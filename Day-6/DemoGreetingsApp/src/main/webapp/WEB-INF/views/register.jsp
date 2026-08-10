<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register — DemoGreetingsApp</title>
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
            background: linear-gradient(135deg, #a78bfa, #6366f1);
            border-radius: 16px;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            margin-bottom: 14px;
            box-shadow: 0 8px 20px rgba(99,102,241,0.4);
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
            border-color: #a78bfa;
            background: rgba(167,139,250,0.08);
            box-shadow: 0 0 0 3px rgba(167,139,250,0.15);
        }

        .btn {
            width: 100%;
            padding: 13px;
            margin-top: 8px;
            background: linear-gradient(135deg, #a78bfa, #6366f1);
            border: none;
            border-radius: 10px;
            color: #ffffff;
            font-size: 1rem;
            font-weight: 600;
            font-family: 'Inter', sans-serif;
            cursor: pointer;
            transition: opacity 0.2s, transform 0.15s, box-shadow 0.2s;
            box-shadow: 0 6px 20px rgba(99,102,241,0.4);
        }

        .btn:hover {
            opacity: 0.9;
            transform: translateY(-1px);
            box-shadow: 0 10px 28px rgba(99,102,241,0.5);
        }

        .btn:active { transform: translateY(0); }

        .footer-link {
            text-align: center;
            margin-top: 22px;
            color: rgba(255,255,255,0.5);
            font-size: 0.875rem;
        }

        .footer-link a {
            color: #a78bfa;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.2s;
        }

        .footer-link a:hover { color: #c4b5fd; }

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
        <div class="logo-icon">✨</div>
    </div>
    <h2>Create Account</h2>
    <p class="subtitle">Join us today — it's free!</p>

    <% if (request.getAttribute("error") != null) { %>
    <div class="error-msg">${error}</div>
    <% } %>

    <form action="/register" method="post">

        <div class="form-group">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" placeholder="Anuj Vishwakarma" required>
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" placeholder="you@example.com" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="••••••••" required>
        </div>

        <button type="submit" class="btn">Create Account</button>

    </form>

    <div class="footer-link">
        Already have an account? <a href="/login">Sign in</a>
    </div>
</div>

</body>
</html>
