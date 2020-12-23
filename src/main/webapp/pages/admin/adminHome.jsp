<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" value="Logout"  onclick="location.href='/logout'"></div>
<h1>Portfolio Management System</h1>
<hr>
<div><h4>Welcome, ${auth.name}</h4></div>
<div class="login-form" class="container">
<form:form action="createBackOfficeUser" method="post" modelAttribute="bouser" class="was-validated">
<h3>Create Back Office User</h3>
<c:if test="${user_name!=null}">
					<p style="color:white;font-size:12px" id="center"> User ${user_name} created successfully!
				</c:if>


<div >
<div class="form-group">
<div><form:input path="userName" name="userName" type="text" title="Unique user name for login, having minimum 6 characters length" class="form-control" placeholder="User Name" required="required" /></div>
<div><form:errors path = "userName" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path="password" name="password" type="password" title="Password for login, having minimum 6 characters length" class="form-control" placeholder="Password" required="required"  /></div>
<div><form:errors path = "password" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path="confirmPassword" name="confirmPassword" type="password" title="Confirm Password for login, having minimum 6 characters length" class="form-control" placeholder="Confirm Password" required="required"  /></div>
<div><form:errors path = "confirmPassword" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path="name" name="name" type="text" title="Name of the user" class="form-control" placeholder="FirstName LastName" required="required"  /></div>
<div><form:errors path = "name" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path="emailId" name="emailId" type="text" title="Email id of the user" class="form-control" placeholder="Email" required="required"  /></div>
<div><form:errors path = "emailId" cssClass="error" /></div>
</div>
<div class="form-group">
<div><form:input path="phNumber" name="phNumber" type="text" title="Phone of the user" class="form-control" placeholder="Mobile" required="required"  /></div>
<div><form:errors path = "phNumber" cssClass="error" /></div>
</div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add BackOffice User"></div>

</form:form>
</div>
</body>
</html>