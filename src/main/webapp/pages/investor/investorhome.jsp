<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/radioselect.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"
	rel="Stylesheet"></link>
<script src="YourJquery source path"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/commonlogin.css">

</head>
<body>
	<jsp:include page="/pages/header.jsp"></jsp:include>
	<div>
		<h4>Welcome, ${auth.name}</h4>
	</div>
	<div class="floatright">
		<label>Currency</label>
		<form action="/investor/redirect" method="get">
			<div>
				<select name="currency" id="currency">
					<option value="" selected disabled>Choose here</option>
					<option value="AED">AED</option>
					<option value="AFN">AFN</option>
					<option value="ALL">ALL</option>
					<option value="AMD">AMD</option>
					<option value="ANG">ANG</option>
					<option value="AOA">AOA</option>
					<option value="ARS">ARS</option>
					<option value="AUD">AUD</option>
					<option value="AWG">AWG</option>
					<option value="AZN">AZN</option>
					<option value="BAM">BAM</option>
					<option value="BBD">BBD</option>
					<option value="BDT">BDT</option>
					<option value="BGN">BGN</option>
					<option value="BHD">BHD</option>
					<option value="BIF">BIF</option>
					<option value="BMD">BMD</option>
					<option value="BND">BND</option>
					<option value="BOB">BOB</option>
					<option value="BRL">BRL</option>
					<option value="BSD">BSD</option>
					<option value="BTN">BTN</option>
					<option value="BSD">BSD</option>
					<option value="BWP">BWP</option>
					<option value="BYN">BYN</option>
					<option value="BZD">BZD</option>
					<option value="CAD">CAD</option>
					<option value="CDF">CDF</option>
					<option value="CHF">CHF</option>
					<option value="CLP">CLP</option>
					<option value="CNY">CNY</option>
					<option value="CRC">CRC</option>
					<option value="CUC">CUC</option>
					<option value="CUP">CUP</option>
					<option value="CVE">CVE</option>
					<option value="CZK">CZK</option>
					<option value="DJF">DJF</option>
					<option value="DKK">DKK</option>
					<option value="DOP">DOP</option>
					<option value="DZD">DZD</option>
					<option value="EGP">EGP</option>
					<option value="ERN">ERN</option>
					<option value="ETB">ETB</option>
					<option value="EUR">EUR</option>
					<option value="FJD">FJD</option>
					<option value="FKP">FKP</option>
					<option value="FOK">FOK</option>
					<option value="GBP">GBP</option>
					<option value="GEL">GEL</option>
					<option value="GGP">GGP</option>
					<option value="GHS">GHS</option>
					<option value="GIP">GIP</option>
					<option value="GMD">GMD</option>
					<option value="GNF">GNF</option>
					<option value="GTQ">GTQ</option>
					<option value="GYD">GYD</option>
					<option value="HKD">HKD</option>
					<option value="HNL">HNL</option>
					<option value="HRK">HRK</option>
					<option value="HTG">HTG</option>
					<option value="HUF">HUF</option>
					<option value="IDR">IDR</option>
					<option value="ILS">ILS</option>
					<option value="IMP">IMP</option>
					<option value="INR">INR</option>
					<option value="IQD">IQD</option>
					<option value="IRR">IRR</option>
					<option value="ISK">ISK</option>
					<option value="JMD">JMD</option>
					<option value="JOD">JOD</option>
					<option value="JPY">JPY</option>
					<option value="KES">KES</option>
					<option value="KGS">KGS</option>
					<option value="KHR">KHR</option>
					<option value="KID">KID</option>
					<option value="KMF">KMF</option>
					<option value="KRW">KRW</option>
					<option value="KWD">KWD</option>
					<option value="KYD">KYD</option>
					<option value="KZT">KZT</option>
					<option value="LAK">LAK</option>
					<option value="LBP">LBP</option>
					<option value="LRD">LRD</option>
					<option value="LSL">LSL</option>
					<option value="LYD">LYD</option>
					<option value="MAD">MAD</option>
					<option value="MDL">MDL</option>
					<option value="MGA">MGA</option>
					<option value="MKD">MKD</option>
					<option value="MMK">MMK</option>
					<option value="MNT">MNT</option>
					<option value="MOP">MOP</option>
					<option value="MRU">MRU</option>
					<option value="MUR">MUR</option>
					<option value="MVR">MVR</option>
					<option value="MWK">MWK</option>
					<option value="MXN">MXN</option>
					<option value="MYR">MYR</option>
					<option value="MYR">MYR</option>
					<option value="MZN">MZN</option>
					<option value="NAD">NAD</option>
					<option value="NGN">NGN</option>
					<option value="NIO">NIO</option>
					<option value="NOK">NOK</option>
					<option value="NPR">NPR</option>
					<option value="NZD">NZD</option>
					<option value="OMR">OMR</option>
					<option value="PAB">PAB</option>
					<option value="PEN">PEN</option>
					<option value="PGK">PGK</option>
					<option value="PHP">PHP</option>
					<option value="PKR">PKR</option>
					<option value="PLN">PLN</option>
					<option value="PYG">PYG</option>
					<option value="QAR">QAR</option>
					<option value="RON">RON</option>
					<option value="RSD">RSD</option>
					<option value="RUB">RUB</option>
					<option value="RWF">RWF</option>
					<option value="SAR">SAR</option>
					<option value="SBD">SBD</option>
					<option value="SCR">SCR</option>
					<option value="SDG">SDG</option>
					<option value="SEK">SEK</option>
					<option value="SGD">SGD</option>
					<option value="SHP">SHP</option>
					<option value="SLL">SLL</option>
					<option value="SOS">SOS</option>
					<option value="SRD">SRD</option>
					<option value="SSP">SSP</option>
					<option value="STN">STN</option>
					<option value="SYP">SYP</option>
					<option value="SZL">SZL</option>
					<option value="THB">THB</option>
					<option value="TJS">TJS</option>
					<option value="TMT">TMT</option>
					<option value="TND">TND</option>
					<option value="TOP">TOP</option>
					<option value="TRY">TRY</option>
					<option value="TTD">TTD</option>
					<option value="TVD">TVD</option>
					<option value="TWD">TWD</option>
					<option value="TZS">TZS</option>
					<option value="UAH">UAH</option>
					<option value="UGX">UGX</option>
					<option value="USD">USD</option>
					<option value="UYU">UYU</option>
					<option value="UZS">UZS</option>
					<option value="VES">VES</option>
					<option value="VND">VND</option>
					<option value="VUV">VUV</option>
					<option value="WST">WST</option>
					<option value="XAF">XAF</option>
					<option value="XCD">XCD</option>
					<option value="XDR">XDR</option>
					<option value="XOF">XOF</option>
					<option value="XPF">XPF</option>
					<option value="YER">YER</option>
					<option value="ZAR">ZAR</option>
					<option value="ZMW">ZMW</option>
				</select> <input type="submit" class="modify-btn" class="btn">
			</div>
		</form>
	</div>
	<br>
	<br>
	<div class="container" style="position: absolute;">
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				id="dashboardlink" data-toggle="tab" href="#dashboard.display:block">Dashboard</a>
			</li>
			<li class="nav-item"><a class="nav-link" id="companieslink"
				data-toggle="tab" href="#dashboard.display:block">Companies</a></li>
			<li class="nav-item"><a class="nav-link" id="stockslink"
				data-toggle="tab" href="#menu2">Stocks</a></li>
			<li class="nav-item"><a class="nav-link" id="commoditieslink"
				data-toggle="tab" href="#menu2">Commodities</a></li>
			<li class="nav-item"><a class="nav-link" id="myprofilelink"
				data-toggle="tab" href="#menu2">My Profile</a></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<div id="dashboard" class="showhide">
		<c:if test="${isCommodityBought!=null}">
			<p style="color: green; font-size: 12px; font-weight: bold">
				Commodity - ${boughtCommodity} with quantity:${boughtQuantity}
				bought!
		</c:if>
		<c:if test="${isCommoditySold!=null}">
			<p style="color: green; font-size: 12px; font-weight: bold">Commodity
				- ${soldCommodity} with quantity:${soldQuantity} sold!
		</c:if>
		<c:if test="${isStockBought!=null}">
			<p style="color: green; font-size: 12px; font-weight: bold">Stock
				- ${boughtStock} with quantity:${boughtQuantity} bought!
		</c:if>
		<c:if test="${isStockSold!=null}">
			<p style="color: green; font-size: 12px; font-weight: bold">Stock
				- ${soldStock} with quantity:${soldQuantity} sold!
		</c:if>
		<c:if test="${payment==true}">
			<p style="color: green; font-size: 12px; font-weight: bold">Amount:
				${amount} INR added successfully to your Portfolio Wallet!
			<p style="color: green; font-size: 12px; font-weight: bold">Total
				Wallet Balance is: ${walletBalance} INR
		</c:if>

		<h3>Dashboard</h3>

		<div id="center">
			<c:if test="${CurrencyCode!=null}">
				<span><label><strong>Current Portfolio
							Value: </strong></label>${currentPortfolioValue} ${CurrencyCode}</span>
				<span>&nbsp;&nbsp;&nbsp;</span>
				<span><label><strong>Amount Invested as on
							date:</strong></label>${amountInvested} ${CurrencyCode}</span>
				<span>&nbsp;&nbsp;&nbsp;</span>
				<span><label><strong>Amount Earned as on
							date:</strong></label>${amountEarned} ${CurrencyCode}</span>
			</c:if>
			<c:if test="${CurrencyCode==null}">
				<span><label><strong>Current Portfolio
							Value: </strong></label>${currentPortfolioValue} INR</span>
				<span>&nbsp;&nbsp;&nbsp;</span>
				<span><label><strong>Amount Invested as on
							date:</strong></label>${amountInvested} INR</span>
				<span>&nbsp;&nbsp;&nbsp;</span>
				<span><label><strong>Amount Earned as on
							date:</strong></label>${amountEarned} INR</span>
			</c:if>
		</div>


		<div id="center">
			<a class="link" href="#" data-toggle="modal" data-target="#mywallet">Portfolio
				Wallet</a>

			<div class="modal fade" id="mywallet" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4>Portfolio Wallet</h4>
						</div>
						<div class="modal-body">
							<p>
								Your current wallet balance is: <strong>${walletBalance}
									INR</strong>
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
		</div>
		<hr>
		<h5 style="font-weight: bold; float: left">Recently Viewed
			Companies:</h5>
		<c:choose>
			<c:when test="${recent_company_list!=null}">
				<div class=" table-wrapper-scroll-y my-custom-scrollbar">
					<ul class="ul-ns">
						<c:forEach var="cl" items="${recent_company_list}">
							<li><a class="link"
								href="companyProfile?companyCode=${cl.companyCode }">${cl.companyTitle }</a></li>
						</c:forEach>
					</ul>
				</div>
			</c:when>
		</c:choose>


	</div>
	<div id="companies" class="showhide" style="display: none;">

		<c:choose>
			<c:when test="${company_list==null || company_list.isEmpty() }">
				<div class="alert alert-info">
					<p>No Companies added yet! Please contact Admin at
						SuperAdmin@pms.com
				</div>
			</c:when>
			<c:otherwise>
				<h3>Company List</h3>
				<div class=" table-wrapper-scroll-y my-custom-scrollbar">

					<table
						class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
						<thead>
							<tr>
								<th>Company Code</th>
								<th>Company Name</th>
								<th>Operations:</th>
								<th>Sector:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cl" items="${company_list}">
								<tr>
									<td>${cl.companyCode}</td>
									<td><a
										href="/investor/companyProfile?companyCode=${cl.companyCode }">${cl.companyTitle}</a></td>
									<td>${cl.operations}</td>
									<td>${cl.sector}</td>
									<td><input hidden="true" type="text" name="companyCode"
										value="${cl.companyCode}" readonly="readonly" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<br>
				<br>
				<div id="center">
					<ul class="ul-ns">
						<li><a class="link" href="/investor/compareCompany">Compare
								Companies</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div id="stocks" class="showhide" style="display: none;">

		<div style="position: absolute; left: 300">
			<form action="/investor/getCompanyList">
				<div class="search-container" id="center">

					<input type="text" name="companyText" id="searchCompany"
						placeholder="Search Company.." name="search"> <span
						id="center"><input type="submit" class="btn btn-primary"
						class="btn" value="Search"></span>

				</div>
			</form>
		</div>
		<div id="center" style="margin: auto;">
		
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="link" data-toggle="collapse" href="#collapse1">Buy
								Stocks</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<div class="panel-body"></div>

						<form:form action="" method="post">
							<c:choose>
								<c:when test="${stock_list==null || stock_list.isEmpty() }">
									<div class="alert alert-info">
										<p>No Stocks added yet! Please contact Admin at
											SuperAdmin@pms.com
									</div>
								</c:when>
								<c:otherwise>
									<div class=" table-wrapper-scroll-y my-custom-scrollbar">
										<table
											class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
											<thead>
												<tr>
													<th>Select</th>
													<th>Stock Code</th>
													<th>Company Name</th>
													<th>Stock Exchange</th>
													<th>Current Price</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="sl" items="${stock_list}">
													<tr>
														<td><input type="radio"
															id="${sl.company.companyCode}" name="stock"
															value="${sl.company.companyCode}" required="required">&nbsp;</td>
														<td>${sl.stockId}</td>
														<td>${sl.company.companyTitle}</td>
														<td>${sl.stockExchange}</td>
														<td>${sl.currentPrice}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div id="center">
										<input type="submit" class="btn btn-primary" class="btn"
											value="Buy Stock" formaction="/investor/buyStocks">
									</div>
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
							<a class="link" data-toggle="collapse" href="#collapse2">Sell
								Stocks</a>
						</h4>
					</div>
					<div id="collapse2" class="panel-collapse collapse">
						<div class="panel-body"></div>
						<form:form action="/investor/orderConfirmationSellStock"
							method="post" modelAttribute="stock">
							<c:choose>
								<c:when
									test="${inv_stock_list==null || inv_stock_list.isEmpty() }">
									<div class="alert alert-info">
										<p>No Stocks purchased yet!.
									</div>
								</c:when>
								<c:otherwise>
									<div class=" table-wrapper-scroll-y my-custom-scrollbar">
										<table
											class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
											<thead>
												<tr>
													<th>Select</th>
													<th>Stock Code</th>
													<th>Company Name</th>
													<th>Current Price</th>
													<th>Available Qty</th>
													<th>Sell Qty</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="sl" items="${inv_stock_list}">
													<tr>
														<td><input type="radio"
															id="${sl.stock.company.companyCode}" name="companyCode"
															value="${sl.stock.company.companyCode}"
															required="required">&nbsp;</td>
														<td>${sl.stock.stockId}</td>
														<td>${sl.stock.company.companyTitle}</td>
														<td>${sl.stock.currentPrice}</td>
														<td>${sl.quantity}</td>
														<td><input type="number"
															class="${sl.stock.company.companyCode} disabledtext"
															name="quantity" min="1" max="${sl.quantity}"
															disabled="disabled" required="required"></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div id="center">
										<input type="submit" class="btn btn-primary" class="btn"
											value="Sell Stock">
									</div>
								</c:otherwise>
							</c:choose>
						</form:form>
						<div class="panel-footer"></div>
					</div>
				</div>
			</div>




		</div>
	</div>
	<div id="commodities" class="showhide" style="display: none;">
		<div id="center" style="margin: auto;">




			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="link" data-toggle="collapse" href="#collapse1">Buy
								Commodities</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<div class="panel-body"></div>

						<form:form action="" method="post">
							<c:choose>
								<c:when
									test="${commodity_list==null || commodity_list.isEmpty() }">
									<div class="alert alert-info">
										<p>No Commodities added yet! Please contact Admin at
											SuperAdmin@pms.com
									</div>
								</c:when>
								<c:otherwise>
									<div class=" table-wrapper-scroll-y my-custom-scrollbar">
										<table
											class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
											<thead>
												<tr>
													<th>Select</th>
													<th>Commodity Code</th>
													<th>Commodity Name</th>
													<th>Current Price</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="coml" items="${commodity_list}">
													<tr>
														<td><input type="radio" id="${coml.commodityCode}"
															name="commodity" value="${coml.commodityCode}"
															required="required">&nbsp;</td>
														<td>${coml.commodityCode}</td>
														<td>${coml.commodityName}</td>
														<td>${coml.currentPrice}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div id="center">
										<input type="submit" class="btn btn-primary" class="btn"
											value="Buy Commodity" formaction="/investor/buyCommodity">
									</div>
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
							<a class="link" data-toggle="collapse" href="#collapse2">Sell
								Commodities</a>
						</h4>
					</div>
					<div id="collapse2" class="panel-collapse collapse">
						<div class="panel-body"></div>
						<form:form action="/investor/orderConfirmationSellCommodity"
							method="post" modelAttribute="commodity">
							<c:choose>
								<c:when
									test="${inv_commodity_list==null || inv_commodity_list.isEmpty() }">
									<div class="alert alert-info">
										<p>No Commodities purchased yet!.
									</div>
								</c:when>
								<c:otherwise>
									<div class=" table-wrapper-scroll-y my-custom-scrollbar">
										<table
											class="table table-striped table-hover table-light customtable margin-auto tableFixHead">
											<thead>
												<tr>
													<th>Select</th>
													<th>Commodity Code</th>
													<th>Commodity Name</th>
													<th>Current Price</th>
													<th>Available Qty</th>
													<th>Sell Qty</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="coml" items="${inv_commodity_list}">
													<tr>
														<td><input type="radio"
															id="${coml.commodity.commodityCode}" name="isSelected"
															value="${coml.commodity.commodityCode}"
															required="required">&nbsp;</td>
														<td>${coml.commodity.commodityCode}</td>
														<td>${coml.commodity.commodityName}</td>
														<td>${coml.commodity.currentPrice}</td>
														<td>${coml.quantity}</td>
														<td><input type="number"
															class="${coml.commodity.commodityCode} disabledtext"
															name="quantity" min="1" max="${coml.quantity}"
															disabled="disabled" required="required"></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div id="center">
										<input type="submit" class="btn btn-primary" class="btn"
											value="Sell Commodity">
									</div>
								</c:otherwise>
							</c:choose>
						</form:form>
						<div class="panel-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="myprofile" class="showhide" style="display: none;">
		<h3>Earnings this week</h3>
		<div id="piechart">
			<img src="" alt="chart">
		</div>
		<hr>
		<a class="link" href="/investor/addMoney">Add Money to Wallet</a>
		<h3>Get Portfolio Report</h3>
		<form action="/investor/generatePortfolioReport">
			<ul class="ul-ns" id="center">
				<li><input type="radio" name="report"
					onclick="document.getElementById('dateShow').style.display='none';document.getElementById('monthShow').style.display='block';"
					id="monthly" value="monthly" required><label for="monthly">Monthly(Current
						Year)</label> <input type="radio" name="report"
					onclick="document.getElementById('dateShow').style.display='none';document.getElementById('monthShow').style.display='none';"
					id="annual" value="annual" required><label for="annual">Annual(Current
						Year)</label> <input type="radio" name="report"
					onclick="document.getElementById('dateShow').style.display='block';document.getElementById('monthShow').style.display='none';"
					id="dateRange" value="dateRange" required><label
					for="dateRange">Date Range</label></li>
				<li><div id="dateShow" style="display: none;">
						<label for="dateRange">From: </label><input type="date"
							name="fromDate" id="from"> <label for="dateRange">To:
						</label><input type="date" name="toDate" id="to">
					</div>
					<div id="monthShow" style="display: none;">
						<select name="month">
							<option value="January">January</option>
							<option value="February">February</option>
							<option value="March">March</option>
							<option value="April">April</option>
							<option value="May">May</option>
							<option value="June">June</option>
							<option value="July">July</option>
							<option value="August">August</option>
							<option value="September">September</option>
							<option value="October">October</option>
							<option value="November">November</option>
							<option value="December">December</option>

						</select>
					</div>
					<div id="center">
						<input type="submit" class="btn btn-primary" class="btn"
							value="Generate Report">
					</div></li>
			</ul>
		</form>
	</div>

	<script src="/js/investorhome.js"></script>
</body>
</html>