<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>
<%@page import="com.tap.model.Menu"%>

<%
List<Menu> menuList=(List<Menu>)request.getAttribute("menuList");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>FoodHub | Menu</title>

<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/navbar.css">

</head>

<body>
<body>

<%@ include file="navbar.jsp" %>

<section class="menu">

<!-- ================= NAVBAR ================= -->


<!-- ================= HEADING ================= -->

<section class="heading">

<h1>Our Menu</h1>

<p>Choose your favourite dishes from our delicious menu</p>

</section>

<!-- ================= MENU ITEMS ================= -->

<div class="container">

<%

if(menuList!=null){

for(Menu m:menuList){

%>

<div class="card">

<div class="image">

<img src="<%=m.getImagePath()%>" alt="Food Image">
<span class="foodType <%= "VEG".equals(m.getFoodType()) ? "veg" : "nonveg" %>">

<%=m.getFoodType()%>

</span>

<span class="available">

<%=m.isAvailable()?"Available":"Out of Stock"%>

</span>

</div>

<div class="details">

<h2><%=m.getItemName()%></h2>

<p><%=m.getDescription()%></p>

<div class="price">

₹ <%=m.getPrice()%>

</div>

<div class="bottom">

<form action="AddToCartServlet" method="post">

<input type="hidden"
name="restaurantId"
value="<%=m.getRestaurantId()%>">

<input type="hidden"
name="menuId"
value="<%=m.getMenuId()%>">

<input type="hidden"
name="quantity"
value="1">

<button type="submit">
Add To Cart
</button>

</form>

</div>

</div>

</div>

<%

}

}

%>

</div>

<!-- ================= FOOTER ================= -->

<footer>

<p>

© 2026 FoodHub | Online Food Delivery Application

</p>

</footer>

</body>
</html>