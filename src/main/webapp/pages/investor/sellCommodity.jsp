<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Commodity</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="/css/common.css">
   <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<h3>User Commodity Details</h3>
<br>
<form:form action="orderConfirmation.jsp" modelAttribute="commodity" method="post">
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
<thead>
<tr><th>Select</th><th> Commodity Name</th><th>Current Price</th><th>Available Qty</th><th>Sell Qty</th></tr>
</thead>
<tbody>
<c:forEach var="coml" items="${commodity_list}">
<tr><td><input type="radio" id="${coml.commodityCode}" name="commodity" value="${coml.commodityCode}">&nbsp;</td><td>${coml.commodityCode}</td><td>${coml.commodityName}</td><td>${coml.currentPrice}</td></tr>
</c:forEach>
</tbody>
<tr><td><input type="radio" name="chck1" value="chck1"></input></td><td>Commodity Name1</td><td>Rs. 1000</td><td>5</td>
<td><input type="number" id="quantity" name="quantity" min="1" max="5">
</table>
</div>
<br>
<div id="center"><button class ="btn btn-primary" type="submit">Sell Selected Commodity</button></div>
</form:form>
</body>
</html>