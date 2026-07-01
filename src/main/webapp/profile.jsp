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

<title>My Profile</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/profile.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="profile-container">

<div class="profile-card">

<h1>

My Profile

</h1>

<table>

<tr>

<td>Name</td>

<td><%=user.getName()%></td>

</tr>

<tr>

<td>Email</td>

<td><%=user.getEmail()%></td>

</tr>

<tr>

<td>Phone</td>

<td><%=user.getPhone()%></td>

</tr>

<tr>

<td>Address</td>

<td><%=user.getAddress()%></td>

</tr>

<tr>

<td>Role</td>

<td><%=user.getRole()%></td>

</tr>

</table>

<div class="buttons">

<a href="editProfile.jsp">

<button>

Edit Profile

</button>

</a>

<a href="MyOrdersServlet">

<button>

My Orders

</button>

</a>

<a href="LogoutServlet">

<button class="logout">

Logout

</button>

</a>

</div>

</div>

</div>

</body>

</html>