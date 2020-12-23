<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Commodity</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<h3>Buy Commodity</h3>

<c:if test="${insufficientAmount != null}">
					<p style="color:red;font-size:15px;" class= "error" id="center">Insufficient Wallet Balance. Kindly add amount in Wallet to proceed!
				</c:if>
<form:form action="/investor/orderConfirmationBuyCommodity" modelAttribute="commodity"  method="post" class="login-form">
<table class="fontwhite">
<tr hidden="true"><th>Commodity Id: </th><td><input type="text" name="commodityCode" value="${commodity.commodityCode }"/></td></tr>
<tr><th>Commodity Name: </th><td>${commodity.commodityName }</td></tr>
<tr><th>Current Price: </th><td>${commodity.currentPrice }</td></tr>
<tr><th>Quantity: </th><td><input type="number" name="quantity" min="1" placeholder="Enter quantity" required="required"></td></tr>
</table>
<br>
<div id="center" ><button class="btn btn-primary">Buy</button></div>
</form:form>
</body>
</html>