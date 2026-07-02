<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>

<%
List<Order> orders=(List<Order>)request.getAttribute("orders");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Orders</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/myOrders.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container">

<h1>

My Orders

</h1>

<%

if(orders==null || orders.isEmpty()){

%>

<div class="empty">

<h2>

No Orders Found

</h2>

<p>

Looks like you haven't ordered anything yet.

</p>

<a href="RestaurantServlet">

<button>

Order Now

</button>

</a>

</div>

<%

}
else{

for(Order order:orders){

%>

<div class="order-card">

<div class="left">

<h2>

Order #<%=order.getOrderId()%>

</h2>

<p>

<b>Date :</b>

<%=order.getOrderDate()%>

</p>

<p>

<b>Payment :</b>

<%=order.getPaymentMode()%>

</p>

<p>

<b>Delivery Address :</b>

<%=order.getDeliveryAddress()%>

</p>

</div>

<div class="right">

<h2>

₹ <%=order.getTotalAmount()%>

</h2>

<span class="status">

<%=order.getStatus()%>

</span>

<br><br>

<div class="btn-group">

<a href="OrderDetailsServlet?orderId=<%=order.getOrderId()%>">

<button>

View Details

</button>

</a>

<a href="DeleteOrderServlet?orderId=<%=order.getOrderId()%>"
onclick="return confirm('Are you sure you want to delete this order?');">

<button class="delete-btn">

Delete

</button>

</a>

</div>

</div>

</div>

<%

}

}

%>

</div>
<script src="js/logout.js"></script>

</body>

</html>