<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Wallet Money</title>
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
<form:form action="/investor/addWalletConfirm" method="post" name="addMoney">
<div class="login-form">
<table class="fontwhite">
<tr><td><label><strong>Amount   </strong></label></td><td><input type="text" name="amount" required="required"></td></tr>
<tr><td><label><strong>Debit card</strong></label></td><td><input type="radio" value="debit" name="paymentMethod" onclick="displayDebitForm()" required="required"><br></td></tr>
<tr><td><label><strong>Credit card</strong></label></td><td><input type="radio" value="debit" name="paymentMethod" onclick="displayDebitForm()" required="required"><br></td></tr>
<tr id="cardNo" style="display:none;"><td><label><strong>Card No</strong></label></td><td><input type="text" name="cardno" required="required"></td></tr>
<tr id="cardHolder" style="display:none;"><td><label><strong>Name on Card</strong></label></td><td><input type="text" name="name" required="required"></td></tr>
<tr id="cvv" style="display:none;"><td><label><strong>CVV</strong></label></td><td><input type="text" name="name" required="required"></td></tr>
<tr id="valid" style="display:none;"><td><label><strong>Valid Through</strong></label></td><td><input type="text" name="name" required="required"></td></tr>
</table>
<span><button class="btn btn-primary" type="submit">Confirm</button></span>
</div>
</form:form>
<script type="text/javascript">
function displayDebitForm(){
document.getElementById('cardNo').style.display='block';
document.getElementById('cardHolder').style.display='block';
document.getElementById('cvv').style.display='block';
document.getElementById('valid').style.display='block';
}
</script>
</body>
</html>