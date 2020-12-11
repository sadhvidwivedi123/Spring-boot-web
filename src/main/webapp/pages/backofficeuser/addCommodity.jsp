<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Commodity</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<div><h3>Add a new Commodity</h3></div>
<div class="form-group">
<label for="comCode"><strong>Commodity Code:</strong> </label>
<input class="form-control" placeholder="Commodity Code" type="number" required>
</div>
<div class="form-group">
<label for="comName"><strong>Commodity Name: </strong></label>
<input class="form-control" placeholder="Commodity Name" type="text" required>
</div>
<div class="form-group">
<label for="price"><strong>Current Price: </strong></label>
<input type="number" class="form-control" placeholder="Commodity Price" required>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Commodity"></div>
</div>
</form>
</div>
</body>
</html>