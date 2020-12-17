<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searched Company List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="/js/radioselect.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>
<script src="YourJquery source path"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/common.css">
  <link rel="stylesheet" href="/css/commonlogin.css">
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
<c:choose>
				<c:when test="${company_list==null || company_list.isEmpty() }">
					<div class="alert alert-info">
						<p>No Companies added yet! Please contact Admin at SuperAdmin@pms.com
					</div>
				</c:when>
				<c:otherwise>
<div class=" table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
<thead>
<tr><th>Company Code</th><th>Company Name</th><th>Operations:</th><th>Sector:</th></tr>
</thead>
<tbody>
<c:forEach var="cl" items="${company_list}">
<tr><td>${cl.companyCode}</td><td><a href="/investor/companyProfile?companyCode=${cl.companyCode }">${cl.companyTitle}</a></td><td>${cl.operations}</td><td>${cl.sector}</td><td><input hidden="true" type="text" name="companyCode" value="${cl.companyCode}" readonly="readonly"/></td></tr>
</c:forEach>
</tbody>
</table>
</div>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Buy Stock" formaction="/investor/buyStocks"></div>
</c:otherwise>
</c:choose>

</body>
</html>