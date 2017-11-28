<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Chart.min.js"></script>
</head>
<body>
	<div class="head">
		<div class="logo">
			<img src="images/logo.png">
		</div>
		<div class="logoname">
			<h2>用户管理系统</h2>
		</div>
		<div class="exit">
			<a href="#">退出</a>
		</div>
		<div class="help">
			<a href="#">帮助</a>
		</div>
	</div>
	<div class="mainpanel">
		<div class="left" id="left">
			<div class="left-guide">
				<ul>
					<li><a href="list">
							<div class="li-box">
								<span>用户查询</span>
							</div>
					</a></li>
					<li><a href="add">
							<div class="li-box">
								<span>用户新增</span>
							</div>
					</a></li>
					<li><a href="analyze">
							<div class="li-box">
								<span>用户分析</span>
							</div>
					</a></li>
				</ul>
				<div class="picture">
					<img src="images/timg.jpg">
				</div>
				<div class="activeUser">当前用户</div>
			</div>
		</div>
		<div class="right" id="right">
			<div class="canvas1">
				<canvas id="myChart2" width="400" height="250" style="float: left;"></canvas>
			</div>
			<div class="canvas2">
				<canvas id="myChart1" width="400" height="250" style="float: left;"></canvas>
			</div>
		</div>
	</div>
	<script>
		var ctx1 = document.getElementById("myChart1").getContext('2d');
		var ctx2 = document.getElementById("myChart2").getContext('2d');
		new Chart(ctx1, {
			type : "line",
			data : {
				labels : ${userCreateData.names},
				datasets : [ {
					label : "创建日期",
					data : ${userCreateData.values},
					fill : false,
// 					lineTension : 0.1
				}]
// 				labels :['创建日期']
			}, 
			options : {
				title:{
					display:true,
					text:'用户创建日期统计'
				}
			},
		});
		new Chart(ctx2, {
			type : "pie",
			data : {
				datasets : [ {
					data : ${userGenderData.values},
					backgroundColor : [ "#FF6384",
							"#36A2EB" ]
				} ],

				// These labels appear in the legend and in the tooltips when hovering different arcs
				labels : [ '男性', '女性' ]
			},
			options : {
				title:{
					display:true,
					text:'用户性别分布统计'
				}
			}
		});
	</script>
</body>
</html>