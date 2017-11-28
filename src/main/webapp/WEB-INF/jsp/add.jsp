<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
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
			<form action="addUser" method="post">
				<div class="ae-information">
					<c:choose>
						<c:when test="${userModel.id==null or userModel.id==0}">
							<h3>新增用户信息</h3>
						</c:when>
						<c:otherwise>
							<h3>编辑用户信息</h3>
							<input type="hidden" name="userModel.id" value="${userModel.id}">
						</c:otherwise>
					</c:choose>
					<ul>
						<li><span>用户名称：</span> <input type="text"
							placeholder="请输入您的用户名！" name="userModel.name" id="username"></li>
						<li><span>登录密码：</span> <input type="password"
							placeholder="请输入您的密码！" name="password" id="password"></li>
						<li><span>重复密码：</span> <input type="password"
							placeholder="请输入您的确认密码！" name="repeatPassword"
							id="repeatPassword"></li>
						<li><span>电子邮箱：</span> <input type="email"
							placeholder="请输入您的邮箱!" name="userModel.email" id="email"></li>
						<li><span>性&emsp;&emsp;别：</span> <label> <input
								type="radio" name="userModel.gender" value="0" checked="checked">男
						</label> <label> <input type="radio" name="userModel.gender"
								value="1">女
						</label></li>
					</ul>
				</div>
				<div class="ae-button">
					<button type="submit" id="button-submit">保存</button>
					<button type="reset">重置</button>
					<button type="button" id="returnUserBtn">返回</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$('#returnUserBtn').click(function() {
			document.location = "list";
		})
	</script>
</body>
</html>