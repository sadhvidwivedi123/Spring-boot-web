<%@page import="java.time.LocalTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Stock</title>
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
<h3>Modify Selected Stock</h3>
<div class="login-form">
<form:form action="/backofficeuser/modifyStockAction" modelAttribute="stock" method="post">
<table class="fontwhite">
<tr>
<th>Company Code: </th>
<td><form:input type="number" path = "companyId" class="form-control" placeholder="Enter Company Code" readonly="true" name="companyId"/></td>
<td><div><form:errors path = "companyId" cssClass="error" /></div></td>
</tr>
<tr>
<th>Stock Exchange: </th>
<td> <form:select path="stockExchange" class="form-control" placeholder="Enter Stock Exchange" required="required" name="stockExchange">  
 <form:option selected="selected" disabled="disabled" value ="" label="Select Stock Exchange"/>
 <form:option value="NSE" label="NSE"/>  
 <form:option value="BSE" label="BSE"/>
 </form:select></td>
 <td><form:errors path = "stockExchange" cssClass="error" /></td>
</tr>
<tr>
<th>Current Price: </th>
<td><form:input type="number" path = "currentPrice" class="form-control" placeholder="Enter Price" required="required" name="currentPrice"/></td>
<td><form:errors path = "currentPrice" cssClass="error" /></td>
</tr>
<tr>
<th>Date: </th>
<td><form:input type="date" path = "date" class="form-control" required="required" name="date" readonly="true" value="<%=LocalDate.now()%>"/></td>
<td><form:errors path = "date" cssClass="error" /></td>
</tr>
<tr>
<th>Time: </th>
<td><form:input type="text" path = "time" class="form-control" placeholder="Enter Time" required="required" name="time" readonly="true" value="<%=LocalTime.now().format(DateTimeFormatter.ofPattern(\"HH:mm:ss\"))%>"/></td>
<td><form:errors path = "date" cssClass="error" /></td>
</tr>
</table>
<br>
<button class="btn">Update</button>
</form:form>
</div>
</body>
</html>