<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portfolio Management System</title>
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
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" value="Existing user? Login"  onclick="location.href='/login'"></div>
<jsp:include page="header.jsp"></jsp:include>
<div class="login-form" class="container">
<form:form method="POST" action="/registration" modelAttribute="user" class="was-validated">
<!-- <form action="/registration" method="post" class="was-validated" name="register"> -->
<div><h3>Investor Registration</h3></div>
<div class="form-group">
<div><form:input path="panId" name="panId" type="text" title="Permanent Account Number" class="form-control" placeholder="PAN" required="required"/></div>
<div><form:errors path = "panId" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "userName" name="userName" type="text" title="Unique user name for login, having minimum 6 characters length" class="form-control" placeholder="Username" required="required"/></div>
<div><form:errors path = "userName" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "password" name="password" type="password" title="Password for login, having minimum 6 characters length" class="form-control" placeholder="Password" required="required"/></div>
<div><form:errors path = "password" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "confirmPassword" name="confirmPassword" type="password" title="Password for login, having minimum 6 characters length" class="form-control" placeholder="Confirm Password" required="required"/></div>
<div><form:errors path = "confirmPassword" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "name" name="name" type="text" title="Full Name of the user" class="form-control" placeholder="FirstName LastName" required="required"/></div>
<div><form:errors path = "name" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "emailId" name="emailId" type="text" title="Email id of the user" class="form-control" placeholder="Email" required="required"/></div>
<div><form:errors path = "emailId" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path = "phNumber" name="phNumber" type="text" title="10 digit mobile number of the user" class="form-control" placeholder="Mobile" required="required"/></div>
<div><form:errors path = "phNumber" cssClass="error" /></div>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn"></div>
<!-- </form> -->
</form:form>
</div>
</body>
</html>
