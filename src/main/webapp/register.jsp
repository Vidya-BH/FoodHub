```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Register</title>

<link rel="stylesheet" href="css/register.css">

</head>

<body>

<div class="register-container">

    <div class="register-box">

        <h2>Create Account</h2>

        <p class="subtitle">Sign up to continue ordering delicious food.</p>

        <form action="RegisterServlet" method="post">

            <input
            type="text"
            name="name"
            placeholder="Full Name"
            required>

            <input
            type="email"
            name="email"
            placeholder="Email Address"
            required>

            <input
            type="text"
            name="phone"
            placeholder="Phone Number"
            required>

            <textarea
            name="address"
            placeholder="Delivery Address"
            required></textarea>

            <input
            type="password"
            name="password"
            placeholder="Password"
            required>

            <input
            type="password"
            name="confirmPassword"
            placeholder="Confirm Password"
            required>

            <button type="submit">

                Register

            </button>

        </form>

        <div class="login-link">

            Already have an account?

            <a href="login.jsp">Login</a>

        </div>

    </div>

</div>

</body>
</html>
```
