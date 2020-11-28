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
   <link rel="stylesheet" href="css/commonlogin.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><h4>Compare Companies</h4></div>
<div><label>Choose a Sector:</label></div>
<div class="dropdown">
    <button class="dropdown-toggle" type="button" data-toggle="dropdown">Select Sector
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a class="dlink" href="#">HealthCare</a></li>
      <li><a class="dlink" href="#">Finance</a></li>
      <li><a class="dlink" href="#">Entertainment</a></li>
    </ul>
  </div>
<div>
<br><br>
<h4>Select companies to compare:</h4>
<form action="" method="get">
<div><input type="checkbox" name="companySelected" value="company1"><strong>Company 1</strong></div>
<div><input type="checkbox" name="companySelected" value="company2"><strong>Company 2</strong></div>
<div><input type="checkbox" name="companySelected" value="company3"><strong>Company 3</strong></div>
<div><input type="checkbox" name="companySelected" value="company4"><strong>Company 4</strong></div>
<div><input type="checkbox" name="companySelected" value="company5"><strong>Company 5</strong></div>
<div><input type="checkbox" name="companySelected" value="company6"><strong>Company 6</strong></div>
<button type="submit">Compare</button>
</form>
<br><br>
<table border="1">
<tr><th>Company Name</th><th>Current Value</th></tr>
<tr><td>Company 1</td><td>Rs. 100</td></tr>
<tr><td>Company 2</td><td>Rs. 200</td></tr>

</table>


</div>
</body>
</html>