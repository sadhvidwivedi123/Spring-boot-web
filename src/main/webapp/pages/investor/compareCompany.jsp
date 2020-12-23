<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compare Companies</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/searchlist.js"></script>
   <link rel="stylesheet" href="/css/commonlogin.css">
   <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div><h4>Compare Companies</h4></div>
<div><label>Choose a Sector:</label></div>
<div class="dropdown">
    <button class="dropdown-toggle btn" type="button" data-toggle="dropdown">Select Sector
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
    <c:forEach var="sl" items="${sectorList}">
      <li><a class="dlink" href="/investor/compareCompanyDisplay?sector=${sl }">${sl}</a></li>
      </c:forEach>
    </ul>
  </div>
<br><br>
<c:choose>
				<c:when test="${companyBySector!=null}">
					
					
<form action="/investor/compareCompanyAction" method="get">
<div class="container-fluid p-0">
  <h4>Select companies to compare:</h4> 
  <table class="table table-striped table-hover table-light customtable">
    <thead>
      <tr><th>Select</th><th>Company Title</th></tr>
    </thead>
    <tbody id="myTable">
    <c:forEach var="cs" items="${companyBySector}">
      <tr><td><input type="checkbox" name="companySelected" value="${cs.companyCode }"></td><td>${cs.companyTitle }</td><td><input hidden="true" type="text" name="sector" value="${cs.sector }"></td></tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>
<div><button type="submit" class="btn">Compare</button></div>
</form>

				</c:when>
				</c:choose>
<br>
<div>

<c:choose>
				<c:when test="${selectedCompanies!=null}">

<table class="table table-striped table-hover table-light customtable">
<tr><th>Company Code</th><th>Company Title</th><th>Operations</th><th>Share Count</th><th>Open Share Price(USD)</th><th>Sector</th><th>Currency</th><th>Turn Over</th></tr>
<c:forEach var="sc" items="${selectedCompanies}">
<tr><td>${sc.companyCode}</td><td>${sc.companyTitle}</td><td>${sc.operations}</td><td>${sc.shareCount}</td><td>${sc.openSharePrice}</td><td>${sc.sector}</td><td>${sc.currency}</td><td>${sc.turnOver}</td></tr>
</c:forEach>
</table>
</c:when>
</c:choose>
</div>
</body>
</html>