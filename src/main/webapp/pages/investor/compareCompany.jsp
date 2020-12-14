<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<div><h4>Compare Companies</h4></div>
<div><label>Choose a Sector:</label></div>
<div class="dropdown">
    <button class="dropdown-toggle btn" type="button" data-toggle="dropdown">Select Sector
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a class="dlink" href="#">HealthCare</a></li>
      <li><a class="dlink" href="#">Finance</a></li>
      <li><a class="dlink" href="#">Entertainment</a></li>
    </ul>
  </div>
<br><br>

<form action="" method="get">
<div class="container-fluid p-0">
  <h4>Select companies to compare:</h4> 
  <input class="form-control" id="myInput" type="text" placeholder="Search.." style="width:30%">
  <br>
  <table class="table table-striped table-hover table-light customtable">
    <thead>
      <tr><th>Select</th><th>Company Title</th></tr>
    </thead>
    <tbody id="myTable">
      <tr><td><input type="checkbox" name="companySelected" value="company1"></td><td>Company1</td></tr>
      <tr><td><input type="checkbox" name="companySelected" value="company2"></td><td>Company2</td></tr>
      <tr><td><input type="checkbox" name="companySelected" value="company3"></td><td>Company3</td></tr>
      <tr><td><input type="checkbox" name="companySelected" value="company4"></td><td>Company4</td></tr>
    </tbody>
  </table>
</div>
<div><button type="submit" class="btn">Compare</button></div>
</form>
<br>
<div>
<table class="table table-striped table-hover table-light customtable">
<tr><th>Company Code</th><th>Company Title</th><th>Operations</th><th>Share Count</th><th>Open Share Price(USD)</th><th>Sector</th><th>Currency</th><th>Turn Over</th></tr>
<tr><td>1</td><td>Company1</td><td>APAC</td><td>100000</td><td>12</td><td>Manufacturing</td><td>INR</td><td>12000900</td></tr>
<tr><td>2</td><td>Company2</td><td>EMEA</td><td>10000</td><td>14</td><td>Finance</td><td>EUR</td><td>15000</td></tr>
<tr><td>3</td><td>Company3</td><td>USA</td><td>500000</td><td>8</td><td>Chemical</td><td>USD</td><td>3000000</td></tr>
</table>
</div>
</body>
</html>