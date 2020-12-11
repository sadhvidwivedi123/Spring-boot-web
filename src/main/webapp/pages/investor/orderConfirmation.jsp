<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
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
<h3>Please confirm transaction details</h3>
<div class="login-form">
<table class="fontwhite">
<tr><td><label><strong>Order Type: </strong></label></td><td><label>Buy/Sell</label></td></tr>
<tr><td><label><strong>Exchange: </strong></label></td><td><label>BSE</label></td></tr>
<tr><td><label><strong>Stock/Commodity Name: </strong></label></td><td><label>XYZ </label></td></tr>
<tr><td><label><strong>Current Stock Price:   </strong></label></td><td><label>Rs. 1500 </label></td></tr>
<tr><td><label><strong>Quantity:   </strong></label></td><td><label>5 </label></td></tr>
<tr><td><label><strong>Total Price:   </strong></label></td><td><label>Rs. 20000 </label></td></tr>
</table>
<span><button type="button" class="btn btn-primary" onclick="javascript:history.back()">Back</button><button class="btn btn-primary" type="button">Confirm</button></span>
</div>
</body>
</html>