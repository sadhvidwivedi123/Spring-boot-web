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
  <link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h4>Add a New Commodity</h4>
<div class="form-group" class="container">
<form class="form-horizontal"  class="container">
<div class="form-group">
<label >Company Code: </label>
<div><input type="number" name="cCode"></div>
</div>
<div class="form-group">
<label>Company Title: </label>
<div><input type="text" name="cTitle"></div>
</div>
<div class="form-group">
<label>Operations: </label>
<div><input type="text" name="cOp"></div>
</div>
<div class="form-group">
<label>Share Count: </label>
<div><input type="number" name="shareCount"></div>
</div>
<div class="form-group">
<label>Open Share Price(USD): </label>
<div><input type="number" name="openSharePrice"></div>
</div>
<div class="form-group">
<label>Sector: </label>
<div><input type="text" name="sector"></div>
</div>
<div class="form-group">
<label>Currency: </label>
<div><input type="text" name="cur"></div>
</div>
<div class="form-group">
<label>Turn Over: </label>
<div><input type="number" name="turnOver"></div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Company IPO"></div>
</form>
</div>
</body>
</html>