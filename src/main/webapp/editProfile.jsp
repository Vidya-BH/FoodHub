<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User"%>

<%
User user=(User)session.getAttribute("loggedInUser");

if(user==null){

	response.sendRedirect("login.jsp");
	return;

}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Profile</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/editProfile.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="edit-container">

<div class="edit-card">

<h1>

Edit Profile

</h1>

<form action="EditProfileServlet" method="post">

<label>

Name

</label>

<input
type="text"
name="name"
value="<%=user.getName()%>"
required>

<label>

Email

</label>

<input
type="email"
name="email"
value="<%=user.getEmail()%>"
readonly>

<label>

Phone

</label>

<input
type="text"
name="phone"
value="<%=user.getPhone()%>"
required>

<label>

Address

</label>

<textarea
name="address"
rows="4"
required><%=user.getAddress()==null?"":user.getAddress()%></textarea>

<label>

Password

</label>

<input
type="password"
name="password"
value="<%=user.getPassword()%>"
required>

<button type="submit">

Update Profile

</button>

</form>

</div>

</div>

</body>

</html>