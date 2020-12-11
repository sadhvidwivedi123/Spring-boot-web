<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Home</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<div class="floatright"><input type="submit" class="btn btn-primary" class="btn" value="Logout"  onclick="location.href='/logout'"></div>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div><h4>Welcome, Investor User</h4></div>
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
<span><label><strong>Current Portfolio Value: </strong></label>1000 INR</span>
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
<ul class="ul-ns">
<li><a class="link" href="buyStocks.jsp">Buy Stocks</a></li>
<li><a class="link" href="sellStocks.jsp">Sell Stocks</a></li>
</ul>
</div>
<div id="commodities" class="showhide" style="display:none;">
<ul class="ul-ns">
<li><a class="link" href="buyCommodity.jsp">Buy Commodity</a></li>
<li><a class="link" href="sellCommodity.jsp">Sell Commodity</a></li>
</ul>
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