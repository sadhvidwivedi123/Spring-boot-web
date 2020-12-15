<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
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
<h3>Please confirm transaction details</h3>
<form:form action="/investor/${buy?'buy':'sell'}${isStock?'Stock':'Commodity'}Confirm" method="post" name="sellCommodityConfirm" modelAttribute="${isStock?'stock':'commodity'}">
<div class="login-form">
<table class="fontwhite">
<tr hidden="true"><th>Commodity Id: </th><td><input type="text" name="commodityCode" value="${commodity.commodityCode }"/></td></tr>
<tr><td><label><strong>Order Type: </strong></label></td><td><label>${buy?"Buy":"Sell" }</label></td></tr>
<tr><td><label><strong>${isStock?"Stock Id:":"Commodity Name:" }  </strong></label></td><td><input type="text" name="${isStock?'stockId':'commodityName'}" readonly="readonly" value="${isStock?stock.stockId:commodity.commodityName}"/>
<tr><td><label><strong>Current Price:   </strong></label></td><td><input type="text" name="currentPrice" readonly="readonly" value="${isStock?stock.currentPrice:commodity.currentPrice}"/></td></tr>
<tr><td><label><strong>Quantity:   </strong></label></td><td><input type="text" name="quantity" readonly="readonly" value="${quantity }"/></td></tr>
<tr><td><label><strong>Total Price:   </strong></label></td><td><input type="text" name="totalPrice" readonly="readonly" value="${isStock?quantity*stock.currentPrice:quantity*commodity.currentPrice}"/></td></tr>
</table>
<span><button type="button" class="btn btn-primary" onclick="javascript:history.back()">Back</button><button class="btn btn-primary" type="submit">Confirm</button></span>
</div>
</form:form>
</body>
</html>