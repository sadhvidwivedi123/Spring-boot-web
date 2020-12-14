<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Back Office User</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/common.css">
  <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" value="Logout"  onclick="location.href='/logout'"></div>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div><h4>Welcome, ${auth.name}</h4></div>
<div class="container" style="position:absolute;">
<ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="companieslink" data-toggle="tab" href="#">Companies</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="stockslink" data-toggle="tab" href="#">Stocks</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="commoditieslink" data-toggle="tab" href="#">Commodities</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="reportslink" data-toggle="tab" href="#">Reports</a>
    </li>
  </ul>

 </div>
<br><br><br>
<div class="showhide" style="display:block;" id="companies">
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='/backofficeuser/createCompanyIPO'" value="Add Company IPO"></div>
<c:if test="${company_name!=null}">
<p style="color:white;font-size:12px"> ${company_name} Company IPO ${isUpdated?"updated":"created"}  successfully!
</c:if>
<c:if test="${stock!=null}">
<p style="color:white;font-size:12px"> Stock for ${stock} ${isUpdated?"updated":"created"} successfully!
</c:if>
<c:if test="${commodity!=null}">
<p style="color:white;font-size:12px"> Commodity:  ${commodity} ${isUpdated?"updated":"created"} successfully!
</c:if>
<h3>List of Companies:</h3>
<br>
<form:form action="/backofficeuser/modifyCompany" method="post">

<c:choose>
				<c:when test="${company_list==null || company_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Companies added yet! Please go ahead and add new company IPO.
					</div>
				</c:when>
				<c:otherwise>
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead" style="width:100%">
<thead>
<tr><th>Select</th><th>Company Code</th><th>Company Title</th><th>Operations</th><th>Share Count</th><th>Open Share Price(USD)</th><th>Sector</th><th>Currency</th><th>Turn Over</th></tr>
</thead>
<tbody>
<c:forEach var="cl" items="${company_list}">
<tr><td><input type="radio" id="${cl.companyCode}" name="company" value="${cl.companyCode}">&nbsp;</td><td>${cl.companyCode}</td><td>${cl.companyTitle}</td><td>${cl.operations}</td><td>${cl.shareCount}</td><td>${cl.openSharePrice}</td><td>${cl.sector}</td><td>${cl.currency}</td><td>${cl.turnOver}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Company"></div>
</c:otherwise>
</c:choose>
</form:form>

</div>
<div class="showhide" style="display:none;" id="stocks">
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='/backofficeuser/createStock'" value="Add Stocks"></div>
<h3>List of Stocks:</h3>
<br>
<form:form action="/backofficeuser/modifyStock" method="post">
<c:choose>
				<c:when test="${stock_list==null || stock_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Stocks added yet! Please go ahead and add new stock.
					</div>
				</c:when>
				<c:otherwise>
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead" style="width:60%">
<thead>
<tr><th>Select</th><th>Company Code</th><th>Stock Exchange</th><th>Current Price</th><th>Date</th><th>Time</th></tr>
</thead>
<tbody>
<c:forEach var="sl" items="${stock_list}">
<tr><td><input type="radio" id="${sl.companyId}" name="stock" value="${sl.companyId}">&nbsp;</td><td>${sl.companyId}</td><td>${sl.stockExchange}</td><td>${sl.currentPrice}</td><td>${sl.date}</td><td>${sl.time}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Stock"></div>
</c:otherwise>
</c:choose>
</form:form>
</div>
<div class="showhide" style="display:none;" id="commodities">
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='/backofficeuser/createCommodity'" value="Add Commodities"></div>
<div><h3>List of Commodities:</h3></div>
<br>
<form:form action="/backofficeuser/modifyCommodity" method="post">
<c:choose>
				<c:when test="${commodity_list==null || commodity_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Commodities added yet! Please go ahead and add new commodity.
					</div>
				</c:when>
				<c:otherwise>
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
<thead>
<tr><th>Select</th><th>Commodity Code</th><th>Commodity Name</th><th>Current Price</th></tr>
</thead>
<tbody>
<c:forEach var="coml" items="${commodity_list}">
<tr><td><input type="radio" id="${coml.commodityCode}" name="commodity" value="${coml.commodityCode}">&nbsp;</td><td>${coml.commodityCode}</td><td>${coml.commodityName}</td><td>${coml.currentPrice}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Commodity"></div>
</c:otherwise>
</c:choose>
</form:form>

</div>
<div class="showhide" style="display:none;" id="reports">
<h3>Get Commission Report:</h3>
<div id="center">
<form action="backOfficeUserReportGeneration.jsp" method="get">
<input type="radio" name="monthly" id="monthly"><label for="monthly">Monthly</label>
<input type="radio" name="annual" id="annual" ><label for="annual">Annual</label>
<input type="radio" name="dateRange" id="dateRange"><label for="dateRange">Date Range</label>
<br><br>
<label for="dateRange">From: </label><input type="date" name="report" id="from">
<label for="dateRange">To: </label><input type="date" name="report" id="to">
<br><br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Generate Report"></div>
</form>
</div>
</div>
<script src="/js/backofficeuser.js"></script>
</body>
</html>