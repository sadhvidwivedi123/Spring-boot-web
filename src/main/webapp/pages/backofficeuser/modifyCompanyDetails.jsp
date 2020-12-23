<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Company Details</title>
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
<jsp:include page="/pages/header2.jsp"></jsp:include>
<h3>Modify Company Details</h3>
<div class="login-form">
<form:form action="/backofficeuser/modifyCompanyAction" method="post" modelAttribute="company">
<table class="fontwhite">
<tr><th>Company Code: </th><td><form:input type="number" placeholder="Enter CompanyCode" name="companyCode" path="companyCode" required="required" readonly="true"/></td></tr>
<tr><form:errors path = "companyCode" cssClass="error" /></tr>
<tr><th>Company Title: </th><td><form:input type="text" placeholder="Enter Company Title" name="companyTitle" path="companyTitle" required="required" /></td></tr>
<tr><form:errors path = "companyTitle" cssClass="error" /></tr>
<tr><th>Operations: </th><td><form:input type="text" placeholder="Enter Operations" name="operations" path="operations" required="required"/></td></tr>
<tr><form:errors path = "operations" cssClass="error" /></tr>
<tr><th>Share Count: </th><td><form:input type="number" placeholder="Enter Share Count" name="shareCount" path="shareCount" required="required"/></td></tr>
<tr><form:errors path = "shareCount" cssClass="error" /></tr>
<tr><th>Open Share Price(USD): </th><td><form:input type="number" placeholder="Enter Open Share Price" name="openSharePrice" path="openSharePrice" required="required"/></td></tr>
<tr><form:errors path = "openSharePrice" cssClass="error" /></tr>
<tr><th>Sector: </th><td><form:input type="text" placeholder="Enter Sector" name="sector" path="sector" required="required"/></td></tr>
<tr><form:errors path = "sector" cssClass="error" /></tr>
<tr><th>Currency: </th><td><form:input type="text" placeholder="Enter Currency" name="currency" path="currency" required="required"/></td></tr>
<tr><form:errors path = "currency" cssClass="error" /></tr>
<tr><th>Turn Over: </th><td><form:input type="number" placeholder="Enter Turnover" name="turnOver" path="turnOver" required="required"/></td></tr>
<tr><form:errors path = "turnOver" cssClass="error" /></tr>
</table>
<br>
<div><button class="btn">Update</button></div>
</form:form>
</div>
</body>
</html>