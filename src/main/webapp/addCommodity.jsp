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
  <link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" class="login-form">
<form  class="was-validated">
<div><h3>Add a New Commodity</h3></div>
<div class="form-group">
<label class="control-label col-sm-4" for="comCode">Commodity Code: </label>
<div><input class="form-control" placeholder="Commodity Code" type="number"></div>
</div>
<div class="form-group">
<label class="control-label col-sm-4" for="comName">Commodity Name: </label>
<div><input class="form-control" placeholder="Commodity Name" type="text"></div>
</div>
<div class="form-group">
<label class="control-label col-sm-4" for="price">Current Price: </label>
<div class="col-sm-10"><input type="number" class="form-control" placeholder="Commodity Price"></div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Commodity"></div>
</form>
</div>
</body>
</html>