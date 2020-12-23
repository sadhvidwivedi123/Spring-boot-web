<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Stocks</title>
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
<div id="center"><h3>Buy ${stock.company.companyTitle} Stocks</h3></div>

<c:if test="${insufficientAmount != null}">
					<p style="color:red;font-size:15px;" class= "error" id="center">Insufficient Wallet Balance. Kindly add amount in Wallet to proceed!
				</c:if>
<form:form action="/investor/orderConfirmationBuyStock" modelAttribute="stock"  method="post" class="login-form">
<table class="fontwhite">
<tr hidden="true"><th>Company Code: </th><td><input type="text" name="companyCode" value="${stock.company.companyCode }"/></td></tr>
<tr hidden="true"><th>Stock Id: </th><td><input type="text" name="stockId" value="${stock.stockId }"/></td></tr>
<tr><th>Exchange: </th><td><input type="radio" id="BSE" name="Exchange" value="${stock.stockExchange}"><label>BSE</label><input type="radio" id="NSE" name="Exchange" value="${stock.stockExchange}" required="required"><label>NSE</label></td></tr>
<tr><th>Stock Id: </th><td><label>${stock.stockId }</label></td></tr>
<tr><th>Current Stock Price:  </th><td><label>${stock.currentPrice}</label></td></tr>
<tr><th>Quantity:  </th><td><input name="quantity" type="number" min="1" placeholder="Enter quantity" required="required"></input></td></tr>

</table>
<div id="center"><button class="btn btn-primary" type="submit">Buy</button></div>
</form:form>
</body>
</html>