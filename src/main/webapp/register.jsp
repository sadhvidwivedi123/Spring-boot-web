<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Registration</title>
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
<div class="login-form" class="container">
<form action="" method="post" class="was-validated">
<div><h3>Investor Registration</h3></div>
<div class="form-group">
<div><input name="pan" type="text" title="Permanent Account Number" class="form-control" placeholder="PAN" required></div>
</div>
<div class="form-group">
<div><input name="username" type="text" title="Unique user name for login, having minimum 6 characters length" class="form-control" placeholder="Username" required></div>
</div>
<div class="form-group">
<div><input name="password" type="password" title="Password for login, having minimum 6 characters length" class="form-control" placeholder="Password" required></div>
</div>
<div class="form-group">
<div><input name="confirmpassword" type="password" title="Password for login, having minimum 6 characters length" class="form-control" placeholder="Confirm Password" required></div>
</div>
<div class="form-group">
<div><input name="name" type="text" title="Full Name of the user" class="form-control" placeholder="FirstName LastName" required></div>
</div>
<div class="form-group">
<div><input name="email" type="text" title="Email id of the user" class="form-control" placeholder="Email" required></div>
</div>
<div class="form-group">
<div><input name="phone" type="text" title="10 digit mobile number of the user" class="form-control" placeholder="Mobile" required></div>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn"></div>
</form>
</div>

</body>
</html>