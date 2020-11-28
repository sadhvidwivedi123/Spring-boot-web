<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/commonlogin.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><h4>Welcome, Back Office User</h4></div>
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
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='addCompanyIPO.jsp'" value="Add Company IPO"></div>
<h3>List of Companies:</h3>
<br>
<form action="modifyCompanyDetails.jsp" method="post">
<table class="table table-striped table-hover table-light customtable">
<tr><td>Select</td><th>Company Code</th><th>Company Title</th><th>Operations</th><th>Share Count</th><th>Open Share Price(USD)</th><th>Sector</th><th>Currency</th><th>Turn Over</th></tr>
<tr><td><input type="checkbox" name="chk1">&nbsp;</td><td>1</td><td>Company1</td><td>APAC</td><td>100000</td><td>12</td><td>Manufacturing</td><td>INR</td><td>12000900</td></tr>
<tr><td><input type="checkbox" name="chk2">&nbsp;</td><td>2</td><td>Company2</td><td>EMEA</td><td>10000</td><td>14</td><td>Finance</td><td>EUR</td><td>15000</td></tr>
<tr><td><input type="checkbox" name="chk3">&nbsp;</td><td>3</td><td>Company3</td><td>USA</td><td>500000</td><td>8</td><td>Chemical</td><td>USD</td><td>3000000</td></tr>
</table>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Company"></div>
</form>

</div>
<div class="showhide" style="display:none;" id="stocks">
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='addStock.jsp'" value="Add Stocks"></div>
<h3>List of Stocks:</h3>
<br>
<form action="modifyStock.jsp" method="post">
<table class="table table-striped table-hover table-light customtable">
<tr><td>Select</td><th>Company Code</th><th>Stock Name</th><th>Stock Exchange</th><th>Current Price</th><th>Date</th><th>Time</th></tr>
<tr><td><input type="checkbox" name="stock1">&nbsp;</td><td>1</td><td>Stock Name1</td><td>BSE and NSE</td><td>13</td><td>11/12/2004</td><td>11:34</td></tr>
<tr><td><input type="checkbox" name="stock2">&nbsp;</td><td>2</td><td>Stock Name2</td><td>NSE</td><td>21</td><td>01/02/2016</td><td>10:02</td></tr>
<tr><td><input type="checkbox" name="stock3">&nbsp;</td><td>3</td><td>Stock Name3</td><td>BSE</td><td>14</td><td>01/01/2020</td><td>12:04</td></tr>
</table>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Stock"></div>
</form>
</div>
<div class="showhide" style="display:none;" id="commodities">
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" onclick="location.href='addCommodity.jsp'" value="Add Commodities"></div>
<h3>List of Commodities:</h3>
<br>
<form action="modifyCommodity.jsp" method="post">
<table class="table table-striped table-hover table-light customtable">
<tr><td>Select</td><th>Commodity Code</th><th>Commodity Name</th><th>Current Price</th></tr>
<tr><td><input type="checkbox" name="com1">&nbsp;</td><td>1</td><td>Crude Oil</td><td>30</td></tr>
<tr><td><input type="checkbox" name="com2">&nbsp;</td><td>2</td><td>Gold</td><td>700</td></tr>
<tr><td><input type="checkbox" name="com3">&nbsp;</td><td>3</td><td>Silver</td><td>830</td></tr>
</table>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Modify Selected Commodity"></div>
</form>

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
<script>
	$("#companieslink").click(function () {
		$(".showhide").hide();
		$("#choosecurrency").show("slow");
		$("#companies").show("slow");
		});
	$("#stockslink").click(function () {
		$(".showhide").hide();
		$("#stocks").show("slow");
		
		});
	$("#commoditieslink").click(function () {
		$(".showhide").hide();
		$("#commodities").show("slow");
		
		});
	$("#reportslink").click(function () {
		$(".showhide").hide();
		$("#reports").show("slow");

		});

	
</script>
</body>
</html>