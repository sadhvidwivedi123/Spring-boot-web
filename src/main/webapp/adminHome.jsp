<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><h4>Welcome, Admin User</h4></div>
<div>
<form>
<h3>Create a new BackOffice User</h3>
<div>
<div><span><label><Strong>Username*:</strong></label><input name="username" type="text" title="Unique user name for login, having minimum 6 characters length" required></span></div>
<div><span><label><strong>Password*:</strong></label><input name="password" type="password" title="Password for login, having minimum 6 characters length" required></span></div>
<div><span><label><strong>Name: </strong></label><input name="name" type="text" title="Name of the user"></span></div>
<div><span><label><strong>E-mail: </strong></label><input name="email" type="text" title="Email id of the user" ></span></div>
<div><span><label><strong>Phone no: </strong></label><input name="phone" type="text" title="Phone of the user" ></span></div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add BackOffice User"></div>

</form>
</div>
</body>
</html>