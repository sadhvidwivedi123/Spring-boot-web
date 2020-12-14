<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Commodity</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/commonlogin.css">
  <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<h3>Modify Selected Commodity</h3>
<div class="login-form">
<form:form action="/backofficeuser/modifyCommodityAction" modelAttribute="commodity" method="post">
<table class="fontwhite">
<tr><th>Commodity Code: </th><td><form:input type="number" path="commodityCode" readonly="true" /></td></tr>
<tr><form:errors path = "commodityCode" cssClass="error" /></tr>
<tr><th>Commodity Name: </th><td><form:input type="text" path="commodityName" required="required"/></td></tr>
<tr><form:errors path = "commodityName" cssClass="error" /></tr>
<tr><th>Current Price: </th><td><form:input type="number" path="currentPrice" required="required"/></td></tr>
<tr><form:errors path = "currentPrice" cssClass="error" /></tr>
</table>
<br>
<div><button class="btn">Update</button></div>
</form:form>
</div>
</body>
</html>