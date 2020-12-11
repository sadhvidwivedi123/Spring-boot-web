<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Company IPO</title>
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
<div><h3>Add a Company</h3></div>
<div class="form-group">
<label >Company Code: </label><input type="number" class="form-control" placeholder="Enter CompanyCode" name="cCode" required>
</div>
<div class="form-group">
<label>Company Title: </label><input type="text" class="form-control" placeholder="Enter Company Title" name="cTitle" required>
</div>
<div class="form-group">
<label>Operations: </label><input type="text" class="form-control" placeholder="Enter Operations" name="cOp" required>
</div>
<div class="form-group">
<label>Share Count: </label><input type="number" class="form-control" placeholder="Enter Share Count" name="shareCount" required>
</div>
<div class="form-group">
<label>Open Share Price(USD): </label><input type="number" class="form-control" placeholder="Enter Open Share Price" name="openSharePrice" required>
</div>
<div class="form-group">
<label>Sector: </label><input type="text" class="form-control" placeholder="Enter Sector" name="sector" required>
</div>
<div class="form-group">
<label>Currency: </label><input type="text" class="form-control" placeholder="Enter Currency" name="cur" required>
</div>
<div class="form-group">
<label>Turn Over: </label><input type="number" class="form-control" placeholder="Enter Turnover" name="turnOver" required>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Company IPO"></div>
</div>
</form>
</div>
</body>
</html>