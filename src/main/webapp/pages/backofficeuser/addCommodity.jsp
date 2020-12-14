<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div class="form" class="container">
<form:form action="/backofficeuser/createCommodity" method="post" class="was-validated" modelAttribute="commodity">
<div>
<div><h3>Add Commodity</h3></div>
<div class="form-group">
<form:input class="form-control" path="commodityCode" name="commodityCode" placeholder="Enter Commodity Code" type="number" required="required"/>
<div><form:errors path = "commodityCode" cssClass="error" /></div>
</div>
<div class="form-group">
<form:input class="form-control" path="commodityName" name="commodityName" placeholder="Enter Commodity Name" type="text" required="required"/>
<div><form:errors path = "commodityName" cssClass="error" /></div>
</div>
<div class="form-group">
<form:input type="number" path="currentPrice" name="currentPrice" class="form-control" placeholder="Enter Commodity Price" required="required"/>
<div><form:errors path = "currentPrice" cssClass="error" /></div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Commodity"></div>
</div>
</form:form>
</div>
</body>
</html>