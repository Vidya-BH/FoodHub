<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Replace Cart</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{

background:#111827;
height:100vh;
display:flex;
justify-content:center;
align-items:center;

}

.container{

width:450px;
background:#1f2937;
padding:35px;
border-radius:15px;
text-align:center;
box-shadow:0 10px 25px rgba(0,0,0,.4);

}

h2{

color:#ff7b00;
margin-bottom:20px;

}

p{

color:white;
font-size:18px;
line-height:30px;
margin-bottom:35px;

}

.buttons{

display:flex;
justify-content:space-between;

}

.cancel{

text-decoration:none;
background:#6b7280;
color:white;
padding:14px 28px;
border-radius:10px;
transition:.3s;

}

.cancel:hover{

background:#4b5563;

}

.replace{

text-decoration:none;
background:#ff7b00;
color:white;
padding:14px 28px;
border-radius:10px;
transition:.3s;

}

.replace:hover{

background:#ff9800;

}

</style>

</head>

<body>

<div class="container">

<h2>Replace Cart?</h2>

<p>

Your cart already contains items from another restaurant.

<br><br>

Do you want to clear your current cart and add this item?

</p>

<div class="buttons">

<a href="CartServlet" class="cancel">

Cancel

</a>

<a href="ReplaceCartServlet" class="replace">

Replace Cart

</a>

</div>

</div>

</body>

</html>