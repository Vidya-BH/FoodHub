<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet" href="css/login.css">

</head>

<body>

<div class="login-container">

    <div class="login-box">

        <h2>Welcome Back</h2>

        <p class="subtitle">

            Login to continue ordering delicious food

        </p>

        <form action="LoginServlet" method="post">

            <input
            type="email"
            name="email"
            placeholder="Email Address"
            required>

            <input
            type="password"
            name="password"
            placeholder="Password"
            required>

            <button type="submit">

                Login

            </button>

        </form>

        <div class="register-link">

            Don't have an account?

            <a href="register.jsp">

                Register

            </a>

        </div>

    </div>

</div>

</body>

</html>