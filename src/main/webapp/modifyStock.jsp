<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Stock</title>
</head>
<body>
<h3>Modify Selected Stock</h3>
<hr>
<form>
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
<td><input type="text" name="stockExchange"></td>
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
<button>Update</button>
</form>
</body>
</html>