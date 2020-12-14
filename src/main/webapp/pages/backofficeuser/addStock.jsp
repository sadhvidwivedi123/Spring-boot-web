<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Stock</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div class="form" class="container">
<form:form action="/backofficeuser/createStock" method="post" class="was-validated" modelAttribute="stock">
<div>
<div><h3>Add Stock</h3></div>
<div class="form-group">
<form:input type="number" path = "companyId" class="form-control" placeholder="Enter Company Code" required="required" name="companyId"/>
<div><form:errors path = "companyId" cssClass="error" /></div>
</div>
<div class="form-group">
 <form:select path="stockExchange" class="form-control" placeholder="Enter Stock Exchange" required="required" name="stockExchange">  
 <form:option selected="selected" disabled="disabled" value ="" label="Select Stock Exchange"/>
 <form:option value="NSE" label="NSE"/>  
 <form:option value="BSE" label="BSE"/>
 </form:select>
 <div><form:errors path = "stockExchange" cssClass="error" /></div>

</div>
<div class="form-group">
<form:input type="number" path = "currentPrice" class="form-control" placeholder="Enter Price" required="required" name="currentPrice"/>
<div><form:errors path = "currentPrice" cssClass="error" /></div>
</div>
<div class="form-group">
<form:input type="date" path = "date" class="form-control" required="required" name="date" readonly="true" value="<%=LocalDate.now()%>"/>
<div><form:errors path = "date" cssClass="error" /></div>
</div>
<div class="form-group">
<form:input type="text" path = "time" class="form-control" placeholder="Enter Time" required="required" name="time" readonly="true" value="<%=LocalTime.now().format(DateTimeFormatter.ofPattern(\"HH:mm:ss\"))%>"/>
<div><form:errors path = "time" cssClass="error" /></div>
</div>
<br>
<div id="center"><button class="btn">Add</button></div>
</div>
</form:form>
</div>
</body>
</html>