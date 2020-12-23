<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: false, // change to true		
	title:{
		text: "Basic Column Chart"
	},
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "column",
		dataPoints: [
			{ label: "week1",  y: 10  },
			{ label: "week2", y: 15  },
			{ label: "week3", y: 25  },
			{ label: "week4",  y: 30  },
			{ label: "week5",  y: 28  },
			{ label: "week6",  y: 55  },
			{ label: "week7",  y: 2222  },
			{ label: "week8",  y: 234  },
			{ label: "week9",  y: 255 },
			{ label: "week10",  y: 200  },
		]
	}
	]
});
chart.render();

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>

</body>
</html>