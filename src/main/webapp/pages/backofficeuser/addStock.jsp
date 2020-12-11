<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Stock</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/commonlogin.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="form" class="container">
<form action="login" method="post" class="was-validated">
<div>
<div><h3>Add a New Stock</h3></div>
<div class="form-group">
<label><strong>Company Code: </strong></label><input type="number" class="form-control" placeholder="Enter Company Code" required name="cCode">
</div>
<div class="form-group">
<label><strong>Stock Name: </strong></label><input type="text" class="form-control" placeholder="Enter Stock Name" required name="sName">
</div>
<div class="form-group">
<label><strong>Stock Exchange: </strong></label><input type="text" class="form-control" placeholder="Enter Stock Exchange" required name="sExchange">
</div>
<div class="form-group">
<label><strong>Current Price: </strong></label><input type="number" class="form-control" placeholder="Enter Price" required name="cPrice">
</div>
<div class="form-group">
<label><strong>Date: </strong></label><input type="date" class="form-control" required name="date">
</div>
<div class="form-group">
<label><strong>Time: </strong></label><input type="text" class="form-control" placeholder="Enter Time" required name="time">
</div>
<br>
<div id="center"><button class="btn">Add</button></div>
</div>
</form>
</div>
</body>
</html>