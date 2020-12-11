<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link rel="stylesheet" href="css/commonlogin.css">
  <link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h3>Modify Company Details</h3>
<div class="login-form">
<form action="" method="post">
<table class="fontwhite">
<tr>
<th>Company Code: </th>
<td><input type="number"></td>
</tr>
<tr>
<th>Company Title: </th>
<td><input type="text"></td>
</tr>
<tr>
<th>Operations: </th>
<td><input type="text"></td>
</tr>
<tr>
<th>Share Count: </th>
<td><input type="number"></td>
</tr>
<tr>
<th>Open Share Price(USD): </th>
<td><input type="number"></td>
</tr>
<tr>
<th>Sector: </th>
<td><input type="text"></td>
</tr>
<tr>
<th>Currency: </th>
<td><input type="text"></td>
</tr>
<tr>
<th>Turn Over: </th>
<td><input type="number"></td>
</tr>
</table>
<br>
<div><button class="btn">Update</button></div>
</form>
</div>
</body>
</html>