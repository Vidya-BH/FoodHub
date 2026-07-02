<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>
<%@ page import="com.tap.model.OrderItem"%>

<%
Order order=(Order)request.getAttribute("order");

List<OrderItem> items=(List<OrderItem>)request.getAttribute("orderItems");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Order Details</title>

<link rel="stylesheet" href="css/navbar.css">

<link rel="stylesheet" href="css/orderDetails.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container">

<h1>

Order Details

</h1>

<div class="order-info">

<p><b>Order ID :</b> <%=order.getOrderId()%></p>

<p><b>Status :</b> <%=order.getStatus()%></p>

<p><b>Payment :</b> <%=order.getPaymentMode()%></p>

<p><b>Address :</b> <%=order.getDeliveryAddress()%></p>

<p><b>Date :</b> <%=order.getOrderDate()%></p>

</div>

<table>

<tr>

<th>Menu ID</th>

<th>Quantity</th>

<th>Price</th>

<th>Total</th>

</tr>

<%

for(OrderItem item:items){

%>

<tr>

<td>

<%=item.getMenuId()%>

</td>

<td>

<%=item.getQuantity()%>

</td>

<td>

₹ <%=item.getPrice()%>

</td>

<td>

₹ <%=item.getPrice()*item.getQuantity()%>

</td>

</tr>

<%

}

%>

</table>

<h2>

Grand Total : ₹ <%=order.getTotalAmount()%>

</h2>

<a href="MyOrdersServlet">

<button>

Back to My Orders

</button>

</a>

</div>
<script src="js/logout.js"></script>

</body>

</html>