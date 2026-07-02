<%@page import="com.tap.model.Cart"%>
<%@page import="com.tap.model.CartItem"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%
Cart cart = (Cart)session.getAttribute("cart");

double grandTotal = 0;
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Your Cart</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/cart.css">

</head>

<body>

<%@ include file="navbar.jsp" %>

<div class="container">

<h1>

Your Cart

</h1>

<p class="subtitle">

Review your selected food items

</p>

<%

if(cart==null || cart.getItems().isEmpty()){

%>

<div class="empty-cart">

<div class="cart-icon">

&#128722;

</div>

<h2>

Your Cart is Empty

</h2>

<p>

Looks like you haven't added any delicious food yet.

</p>

<a href="RestaurantServlet" class="shop-btn">

Continue Shopping

</a>

</div>

<%

}else{

%>

<table>

<thead>

<tr>

<th>

Image

</th>

<th>

Item

</th>

<th>

Price

</th>

<th>

Quantity

</th>

<th>

Total

</th>

<th>

Action

</th>

</tr>

</thead>

<tbody>

<%

for(CartItem item : cart.getItems()){

double total=item.getPrice()*item.getQuantity();

grandTotal+=total;

%>

<tr>

<td>

<img

class="food-img"

src="<%=item.getImagePath()%>"

alt="Food Image">

</td>

<td>

<%=item.getItemName()%>

</td>

<td>

₹<%=item.getPrice()%>

</td>

<td>

<div class="quantity">

<form action="UpdateCartServlet" method="post">

<input type="hidden"
name="menuId"
value="<%=item.getMenuId()%>">

<input type="hidden"
name="action"
value="minus">

<button type="submit" class="qty-btn">

-

</button>

</form>

<div class="qty">

<%=item.getQuantity()%>

</div>

<form action="UpdateCartServlet" method="post">

<input type="hidden"
name="menuId"
value="<%=item.getMenuId()%>">

<input type="hidden"
name="action"
value="plus">

<button type="submit" class="qty-btn">

+

</button>

</form>

</div>

</td>

<td>

₹<%=total%>

</td>

<td>

<form action="RemoveCartServlet"
      method="post"
      onsubmit="return confirmRemove()">

<input type="hidden"
name="menuId"
value="<%=item.getMenuId()%>">

<button type="submit" class="remove-btn">

Remove

</button>

</form>

</td>

</tr>

<%

}

%>

</tbody>

</table>

<div class="total">

Grand Total : ₹<%=grandTotal%>

</div>

<div class="cart-buttons">

<a href="RestaurantServlet" class="shop-btn">

Add More Items

</a>

<a href="checkout.jsp" class="checkout-btn">

Proceed To Checkout

</a>

</div>

<%

}

%>

</div>
<script src="js/logout.js"></script>
<script src="js/remove.js"></script>

</body>

</html>