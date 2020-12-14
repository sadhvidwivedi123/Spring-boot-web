<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Home</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="/js/radioselect.js"></script>
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
<div class="floatright">
<label>Choose a currency:</label>
<form action="" method="post">
<div>
<select name="investorCurrency" id="investorCurrency">
  <option value="INR">INR</option>
  <option value="USD">USD</option>
  <option value="CAD">CAD</option>
  <option value="EUR">EUR</option>
</select>
<input type="submit" class="modify-btn" class="btn"></div>
</form>
</div>

<div class="container" style="position:absolute;">
<ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="dashboardlink" data-toggle="tab" href="#dashboard.display:block">Dashboard</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="recentcomlink" data-toggle="tab" href="#dashboard.display:block">Recent Companies</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="companieslink" data-toggle="tab" href="#dashboard.display:block">Companies</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="stockslink" data-toggle="tab" href="#menu2">Stocks</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="commoditieslink" data-toggle="tab" href="#menu2">Commodities</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="myprofilelink" data-toggle="tab" href="#menu2">My Profile</a>
    </li>
  </ul>

 </div>
<br><br><br>
<div id="dashboard" class="showhide">
<h3>Dashboard</h3>

<div id="center">
<span><label><strong>Current Portfolio Value: </strong></label>${currentPortfolioValue} INR</span>
<span>&nbsp;&nbsp;&nbsp;</span>
<span><label><strong>Amount Invested as on date:</strong></label>5000 INR</span>
<span>&nbsp;&nbsp;&nbsp;</span>
<span><label><strong>Amount Earned as on date:</strong></label>300 INR</span>
</div>


<div id="center" >
  <a class="link" href="#" data-toggle="modal" data-target="#mywallet">Portfolio Wallet</a>

  <div class="modal fade" id="mywallet" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
        <h4>Portfolio Wallet</h4>
        </div>
        <div class="modal-body">
          <p>Your current wallet balance is: <strong>1500 INR</strong></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  </div>
   
</div>

<div id="recentlyviewedcompany" style="display:none;" class="showhide">
<h3>Recently Viewed Companies</h3>

<ul class="ul-ns">
<li><a class="link" href="companyProfile.jsp">Company1</a></li>
<li><a class="link" href="companyProfile.jsp">Company2</a></li>
<li><a class="link" href="companyProfile.jsp">Company3</a></li>
</ul>

</div>
<div id="companies" class="showhide" style="display:none;">
<form action="">
<div class="search-container" id="center">
 
      <input type="text" placeholder="Search Company.." name="search">
      <span id="center" ><input type="submit" class="btn btn-primary" class="btn" value="Search"></span>
    
  </div>
 </form>
<ul class="ul-ns">
<li><a class="link" href="compareCompany.jsp">Compare Companies</a></li>
</ul>
<br>
</div>

<div id="stocks" class="showhide" style="display:none;">
<div id="center" style="margin:auto;">
<form:form action="/backofficeuser/modifyCompany" method="post">
<c:choose>
				<c:when test="${company_list==null || company_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Companies added yet! Please contact Admin at SuperAdmin@pms.com
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
<span id="center"><input type="submit" class="btn btn-primary" class="btn" value="Buy Stocks"></span>
<span id="center"><input type="submit" class="btn btn-primary" class="btn" value="Sell Stocks"></span>
</c:otherwise>
</c:choose>
</form:form>
</div>
</div>
<div id="commodities" class="showhide" style="display:none;">
<div id="center" style="margin:auto;">




<div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a class="link" data-toggle="collapse" href="#collapse1">Buy Commodities</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body"></div>
        
        <form:form action="" method="post">
<c:choose>
				<c:when test="${commodity_list==null || commodity_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Commodities added yet! Please contact Admin at SuperAdmin@pms.com
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
<tr><td><input type="radio" id="${coml.commodityCode}" name="commodity" value="${coml.commodityCode}" required="required">&nbsp;</td><td>${coml.commodityCode}</td><td>${coml.commodityName}</td><td>${coml.currentPrice}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Buy Commodity" formaction="/investor/buyCommodity"></div>
</c:otherwise>
</c:choose>
</form:form>
        <div class="panel-footer"></div>
      </div>
    </div>
</div>
<br>



<div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a class="link" data-toggle="collapse" href="#collapse2">Sell Commodities</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body"></div>
 <form:form action="/investor/orderConfirmationSellCommodity" method="post" modelAttribute="commodity">
<c:choose>
				<c:when test="${inv_commodity_list==null || inv_commodity_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Commodities purchased yet!.
					</div>
				</c:when>
				<c:otherwise>
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
<thead>
<tr><th>Select</th><th>Commodity Code</th><th>Commodity Name</th><th>Current Price</th><th>Available Qty</th><th>Sell Qty</th></tr>
</thead>
<tbody>
<c:forEach var="coml" items="${inv_commodity_list}">
<tr><td><input type="radio" id="${coml.commodity.commodityCode}" name="isSelected" value="${coml.commodity.commodityCode}" required="required">&nbsp;</td><td>${coml.commodity.commodityCode}</td><td>${coml.commodity.commodityName}</td><td>${coml.commodity.currentPrice}</td><td>${coml.quantity}</td><td><input type="number" class="${coml.commodity.commodityCode} disabledtext" name="quantity" min="1" max="${coml.quantity}" disabled="disabled" required="required"></td></tr>
</c:forEach>
</tbody>
</table>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Sell Commodity"></div>
</c:otherwise>
</c:choose>
</form:form>
        <div class="panel-footer"></div>
      </div>
    </div>
</div>
</div>
</div>
<div id="myprofile" class="showhide" style="display:none;">
<h3>Earnings this week</h3>
<div id="piechart">
<img src="" alt="chart">
</div>
<hr>
<h3>Get Portfolio Report</h3>
<ul class="ul-ns" id="center">
<li><input type="radio" name="report" id="monthly"><label for="monthly">Monthly</label>
<input type="radio" name="report" id="annual" ><label for="annual">Annual</label>
<input type="radio" name="report" id="dateRange"><label for="dateRange">Date Range</label>
</li>
<li><label for="dateRange">From: </label><input type="date" name="report" id="from">
<label for="dateRange">To: </label><input type="date" name="report" id="to">
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Generate Report"></div></li>
</ul>
</div>
   <script src="/js/investorhome.js"></script>
</body>
</html>