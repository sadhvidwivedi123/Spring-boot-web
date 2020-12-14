<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Stocks</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<h3>Username Stock Details</h3>
<form action="orderConfirmation.jsp" class="login-form">
<table border=1 class="table table-striped table-hover table-light customtable">
<tr><th>Select</th><th> Stock Name</th><th>Current Price</th><th>Quantity</th><th>Quantity to sell</th></tr>
<tr><td><input type="checkbox" name="chck1" value="chck1"></input></td><td>Stock Name1</td><td>Rs. 1000</td><td>5</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="quantity" id="quantity">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select></td>
</tr>
<tr><td><input type="checkbox" name="chck2" value="chck2"></input></td><td>Stock Name2</td><td>Rs. 2000</td><td>8</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="quantity" id="quantity">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select></td>
</tr>
<tr><td><input type="checkbox" name="chck3" value="chck3"></input></td><td>Stock Name3</td><td>Rs. 3000</td><td>5</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="quantity" id="quantity">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select></td>
</tr>
<tr><td><input type="checkbox" name="chck4" value="chck4"></input></td><td>Stock Name4</td><td>Rs. 1000</td><td>5</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="quantity" id="quantity">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select></td>
</tr>

</table>
<br>
<button type="submit" class="btn btn-primary">Sell Selected Stocks</button>
</form>
</body>
</html>