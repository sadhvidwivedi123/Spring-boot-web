<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/commonlogin.css">
   
</head>
<body>
<h1>Portfolio Management System</h1>
<hr>
<div class="form" class="container">
<form action="/validateLogin" method="post" class="was-validated">
<div>
<div><h3>Login</h3></div>
<c:if test="${param.error != null}">
					<p class= "error" id="center">Invalid Credentials! Access Denied!
				</c:if>
<c:if test="${registerSuccess==true}">
<p style="color:green;font-size:12px;font-weight:bold"> Registration successful, Kindly Login to proceed!
</c:if>
<div class="form-group">
<input type="hidden" name="${_csrf.parameterName}"	
						value="${_csrf.token}" />
<label>UserName</label><input name="userName" type="text" class="form-control" placeholder="Enter username" autocomplete="off" pattern=".{6,}" required>
</div>
 <div class="form-group">
<label>Password</label><input name="password" type="password" class="form-control" placeholder="Enter password" pattern=".{6,}" required>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn"></div>
</div>
<div id="center"><label>Not an existing Investor? &nbsp;</label><a href="/home">Register!</a></div>
</form>

</div>
</body>
</html>