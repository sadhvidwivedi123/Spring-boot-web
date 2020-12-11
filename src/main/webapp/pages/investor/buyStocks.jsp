<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Stocks</title>
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
<div id="center"><h3>Buy Stocks</h3></div>
<form action="" method="get">
<div class="floatright">
    
      <input type="text" placeholder="Search Stock.." name="search">
      <button type="submit">Search</button>
  </div>
  <br>
</form>
<br>
<h5>Company 1 Stock Details</h5>
<div class="login-form">
<form action="orderConfirmation.jsp" method="post">
<table class="fontwhite">
<tr><td><label><strong>Exchange: </strong></label></td><td><input type="radio" id="BSE" name="Exchange" value="BSE"><label>BSE</label><input type="radio" id="NSE" name="Exchange" value="NSE"><label>NSE</label></td></tr>
<tr><td><label><strong>Stock Name: </strong></label></td><td><label>XYZ </label></td></tr>
<tr><td><label><strong>Current Stock Price:   </strong></label></td><td><label>Rs. 1500 </label></td></tr>
<tr><td><label><strong>Quantity:   </strong></label></td><td><input name="quantity" type="number"></input></td></tr>
<tr><td><label><strong>Total Price:   </strong></label></td><td><label>Rs. 20000 </label></td></tr>

</table>
<div id="center"><button class="btn btn-primary" type="submit">Buy</button></div>
</form>
</div>

</body>
</html>