<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Commodity</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h3>Buy Commodity</h3>
<form action="" method="get">
<div class="floatright">
    
      <input type="text" placeholder="Search Commodities.." name="search">
      <button type="submit">Search</button>
  </div>
  <br>
</form>
<form action="orderConfirmation.jsp" method=post class="login-form">
<table class="fontwhite">
<tr><th>Commodity Name: </th><td>Crude Oil</td></tr>
<tr><th>Current Price: </th><td>1500</td></tr>
<tr><th>Quantity: </th><td><input type="number" name="quantity"></td></tr>
</table>
<br>
<div id="center" ><button class="btn btn-primary">Buy</button></div>
</form>
</body>
</html>