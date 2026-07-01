<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html> <html> <head> <meta charset="UTF-8"> <title>Order Success</title> <link rel="stylesheet" href="css/navbar.css"> <link rel="stylesheet" href="css/orderSuccess.css"> </head> <body>

<jsp:include page="navbar.jsp"/>

<div class="success-container"> <div class="success-card"> <div class="tick">

✔

</div> <h1>

Order Placed Successfully!

</h1> <p>

Thank you for ordering with FoodHub.

</p> <p>

Your delicious food is being prepared.

</p> <div class="buttons"> <a href="RestaurantServlet"> <button>

Continue Shopping

</button> </a> <a href="MyOrdersServlet"> <button class="order-btn">

My Orders

</button>
 </a> 
 </div> 
 </div> 
 </div> 
 </body>
  </html>