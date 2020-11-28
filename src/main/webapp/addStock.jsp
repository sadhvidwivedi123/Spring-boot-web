<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Stock</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   <script src="/js/pms.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/common.css">
</head>
<body>

<h1>Add a New Stock</h1>
<form method="get">
<table>
<tr>
<th>Company Code: </th>
<td><input type="number" name="cCode"></td>
</tr>
<tr>
<th>Stock Name: </th>
<td><input type="text" name="sName"></td>
</tr>
<tr>
<th>Stock Exchange: </th>
<td><input type="text" name="sExchange"></td>
</tr>
<tr>
<th>Current Price: </th>
<td><input type="number" name="cPrice"></td>
</tr>
<tr>
<th>Date: </th>
<td><input type="text" name="date"></td>
</tr>
<tr>
<th>Time: </th>
<td><input type="text" name="time"></td>
</tr>
</table>
<br>
<button>Add</button>
</form>
</body>
</html>