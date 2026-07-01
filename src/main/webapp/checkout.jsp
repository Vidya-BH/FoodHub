<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<%@ page import="com.tap.model.User"%>

<%
Cart cart=(Cart)session.getAttribute("cart");

User user=(User)session.getAttribute("loggedInUser");

if(user==null){

	response.sendRedirect("login.jsp");
	return;

}

if(cart==null || cart.getItems().isEmpty()){

	response.sendRedirect("CartServlet");
	return;

}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Checkout</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/checkout.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="checkout-container">

<h1>

Checkout

</h1>

<form action="PlaceOrderServlet" method="post">

<div class="section">

<h2>

Delivery Details

</h2>

<div class="details">

<p>

<b>Name :</b>

<%=user.getName()%>

</p>

<p>

<b>Phone :</b>

<%=user.getPhone()%>

</p>

<p>

<b>Email :</b>

<%=user.getEmail()%>

</p>

</div>

<label>

Delivery Address

</label>

<textarea
name="address"
rows="4"
required><%=user.getAddress()==null?"":user.getAddress()%></textarea>

</div>

<div class="section">

<h2>

Payment Method

</h2>

<label>

<input
type="radio"
name="paymentMode"
value="Cash On Delivery"
checked>

Cash On Delivery

</label>

<br><br>

<label>

<input
type="radio"
name="paymentMode"
value="UPI">

UPI

</label>

<br><br>

<label>

<input
type="radio"
name="paymentMode"
value="Credit Card">

Credit Card

</label>

</div>

<div class="section">

<h2>

Order Summary

</h2>

<table>

<tr>

<th>

Item

</th>

<th>

Qty

</th>

<th>

Price

</th>

<th>

Total

</th>

</tr>

<%

for(CartItem item:cart.getItems()){

%>

<tr>

<td>

<%=item.getItemName()%>

</td>

<td>

<%=item.getQuantity()%>

</td>

<td>

₹ <%=item.getPrice()%>

</td>

<td>

₹ <%=item.getTotalPrice()%>

</td>

</tr>

<%

}

%>

</table>

</div>

<div class="grand-total">

Grand Total : ₹ <%=cart.getGrandTotal()%>

</div>

<button type="submit">

Place Order

</button>

</form>

</div>

</body>

</html>