<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: false, // change to true		
	title:{
		text: "Earning Trend - Past 10 Weeks"
	},
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "column",
		dataPoints: [
			{ label: "week1",  y: ${earnTrend[0]}},
			{ label: "week2", y: ${earnTrend[1]}  },
			{ label: "week3", y: ${earnTrend[2]}  },
			{ label: "week4",  y: ${earnTrend[3]}  },
			{ label: "week5",  y: ${earnTrend[4]}  },
			{ label: "week6",  y: ${earnTrend[5]}  },
			{ label: "week7",  y: ${earnTrend[6]}  },
			{ label: "week8",  y: ${earnTrend[7]}  },
			{ label: "week9",  y: ${earnTrend[8]} },
			{ label: "week10",  y: ${earnTrend[9]}  },
		]
	}
	]
});
chart.render();

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 50%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>

</body>
</html>