<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portfolio Management System-Login</title>
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
<div class="form" class="container">
<form action="/validateLogin" method="post" class="was-validated">
<div>
<div><h3>Login</h3></div>
<div class="form-group">
<label>UserName</label><input name="userName" type="text" class="form-control" placeholder="Enter username" autocomplete="off" required>
</div>
 <div class="form-group">
<label>Password</label><input name="password" type="password" class="form-control" placeholder="Enter password" required>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn"></div>
</div>
<div id="center"><label>Not an existing Investor? &nbsp;</label><a href="/home">Register!</a></div>
</form>

</div>
</body>
</html>