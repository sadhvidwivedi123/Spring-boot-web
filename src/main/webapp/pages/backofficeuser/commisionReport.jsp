<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commission Report</title>
</head>
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
<body>
<jsp:include page="/pages/header2.jsp"></jsp:include>
<h3>Commission Report</h3>
<c:choose>
				<c:when test="${report==null || report.isEmpty() }">
					<div class="alert alert-info">
						<p>No Transactions found for this period!
					</div>
				</c:when>
				<c:otherwise>
<table class="table table-striped table-hover table-light customtable tableFixHead" style="width:100%">
<thead>
<tr><th>Commission Id</th><th>Commission Value</th><th>Date</th></tr>
</thead>
<tbody>
<c:forEach var="value" items="${report}">
<tr><td>${value.commisionId}</td><td>${value.commisionValue}</td><td>${value.date}</td></tr>
</c:forEach>
</tbody>
</table>
</c:otherwise>
</c:choose>
<br>
</body>
</html>