<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Profile</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/commonlogin.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><h4><strong>Company Details</strong></h4></div>
<br>
<table class="table table-striped table-hover table-light customtable"><tr><td><strong>Company Code: </strong></td><td>1</td></tr>
<tr><td><strong>Company Title: </strong></td><td>Company1</td></tr>
<tr><td><strong>Operations: </strong></td><td>EMEA</td></tr>
<tr><td><strong>Share Count: </strong></td><td>1200</td></tr>
<tr><td><strong>Open Share Price(USD): </strong></td><td>1500</td></tr>
<tr><td><strong>Sector:</strong> </td><td>Manufacturing</td></tr>
<tr><td><strong>Currency: </strong></td><td>EUR</td></tr>
<tr><td><strong>Turn Over: </strong></td><td>1223244</td></tr>
</table>
<button onclick="location.href='buyStocks.jsp'" class="btn btn-primary" class="btn">Buy Stocks</button>
<button onclick="location.href='sellStocks.jsp'" class="btn btn-primary" class="btn">Sell Stocks</button>
</body>
</html>