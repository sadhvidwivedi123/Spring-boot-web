<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Company IPO</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/commonlogin.css">
  <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<jsp:include page="/pages/header2.jsp"></jsp:include>
<div class="form" class="container">
<form:form action="/backofficeuser/createCompanyIPO" method="post" class="was-validated" modelAttribute="company">
<div>
<div><h3>Add a Company</h3></div>
<div class="form-group">
<label >Company Code: </label>
<form:input type="number" class="form-control" placeholder="Enter CompanyCode" name="companyCode" path="companyCode" required="required"/>
<div><form:errors path = "companyCode" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Company Title: </label>
<form:input type="text" class="form-control" placeholder="Enter Company Title" name="companyTitle" path="companyTitle" required="required"/>
<div><form:errors path = "companyTitle" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Operations: </label>
<form:input type="text" class="form-control" placeholder="Enter Operations" name="operations" path="operations" required="required"/>
<div><form:errors path = "operations" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Share Count: </label>
<form:input type="number" class="form-control" placeholder="Enter Share Count" name="shareCount" path="shareCount" required="required"/>
<div><form:errors path = "shareCount" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Open Share Price(USD): </label>
<form:input type="number" class="form-control" placeholder="Enter Open Share Price" name="openSharePrice" path="openSharePrice" required="required"/>
<div><form:errors path = "openSharePrice" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Sector: </label>
<form:input type="text" class="form-control" placeholder="Enter Sector" name="sector" path="sector" required="required"/>
<div><form:errors path = "sector" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Currency: </label>
<form:input type="text" class="form-control" placeholder="Enter Currency" name="currency" path="currency" required="required"/>
<div><form:errors path = "currency" cssClass="error" /></div>
</div>
<div class="form-group">
<label>Turn Over: </label>
<form:input type="number" class="form-control" placeholder="Enter Turnover" name="turnOver" path="turnOver" required="required"/>
<div><form:errors path = "turnOver" cssClass="error" /></div>
</div>
<br>
<div id="center"><input type="submit" class="btn btn-primary" class="btn" value="Add Company IPO"></div>
</div>
</form:form>
</div>
</body>
</html>