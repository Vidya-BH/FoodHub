<%@page import="java.util.List"%>
<%@page import="com.tap.model.Restaurant"%>

<%
List<Restaurant> restaurants =
(List<Restaurant>)request.getAttribute("restaurants");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>FoodHub | Restaurants</title>

<link rel="stylesheet" href="css/restaurants.css">

<link rel="stylesheet" href="css/navbar.css">

</head>

<body>

<%@ include file="navbar.jsp" %>

<section class="hero">

<h1>

Discover the Best Restaurants Near You

</h1>

<p>

Order delicious food from your favourite restaurants.

</p>

<form action="RestaurantServlet" method="get" class="search-form">

<input
type="search"
name="search"
placeholder="&#128269; Search Restaurant or Cuisine..."
autocomplete="off">

</form>

</section>

<div class="container">

<%

if(restaurants != null){

for(Restaurant r : restaurants){

%>

<div class="card">

<img src="<%=r.getImagePath()%>" alt="Restaurant">

<div class="details">

<h2>

<%=r.getRestaurantName()%>

</h2>

<p>

&#127869; <%=r.getCuisineType()%>

</p>

<p>

&#11088; <%=r.getRating()%>

</p>

<p>

&#128337; <%=r.getDeliveryTime()%> mins

</p>

<p>

&#128205; <%=r.getAddress()%>

</p>

<p>

&#8377; <%=r.getPriceForTwo()%> for two

</p>

<a href="MenuServlet?restaurantId=<%=r.getRestaurantId()%>">

<button>

View Menu

</button>

</a>

</div>

</div>

<%

}

}else{

%>

<h2 style="color:white;text-align:center;margin-top:50px;">

No Restaurants Available

</h2>

<%

}

%>

</div>

</body>

</html>