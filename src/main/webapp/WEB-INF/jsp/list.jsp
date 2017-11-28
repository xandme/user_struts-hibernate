<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>混合布局 - 自适应宽度</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/page.js"></script>
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
		<div class="left">
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
		<div class="right">
			<form action="findName">
				<div class="search">
					<span>用户名称：</span> <input type="search" name="nameKey">
					<button>查询</button>
				</div>
			</form>
			<div class="information">
				<div class="tableInformation">
					<table width="95%">
						<thead>
							<tr height="40px">
								<td width="5%">编号</td>
								<td width="10%">用户名称</td>
								<td width="20%">邮箱</td>
								<td width="5%">性别</td>
								<td width="20%">创建时间</td>
								<td width="20%">更新时间</td>
								<td width="20%">操作</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listUser}" var="lend">
								<tr>
									<td>${lend.id }</td>
									<td>${lend.name}</td>
									<td>${lend.email}</td>
									<td><c:choose>
											<c:when test="${lend.gender }">男</c:when>
											<c:otherwise>女</c:otherwise>
										</c:choose>
									<td>${lend.createDate}</td>
									<td>${lend.updateDate}</td>
									<td><a href="edit?userModel.id=${lend.id }">编辑</a>&nbsp;&nbsp;<a
										href="javaScript:doDeleteUser('${lend.name}','${lend.id }')">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pageSet">
						<ul>
							<li>共<span class="red">${page.totalPage}</span>页，<span
								class="red">${page.totalSize}</span>条记录，当前第<span class="red">${page.pageNow}</span>页
							</li>
							<li><c:if test="${page.totalPage<=1}">
									<a href="list?pageNow=1">首页</a>
									<a href="list?pageNow=${page.pageNow}">«上一页</a>
									<a href="list?pageNow=${page.pageNow}">下一页»</a>
									<a href="list?pageNow=${page.pageNow}">尾页</a>
								</c:if> <c:if test="${page.totalPage>1}">
									<c:choose>
										<c:when test="${page.pageNow==1}">
											<a href="list?pageNow=1">首页</a>
											<a href="list?pageNow=${page.pageNow}">«上一页</a>
											<a href="list?pageNow=${page.pageNow+1}">下一页»</a>
											<a href="list?pageNow=${page.totalPage}">尾页</a>
										</c:when>
										<c:when test="${page.pageNow==page.totalPage}">
											<a href="list?pageNow=1">首页</a>
											<a href="list?pageNow=${page.pageNow-1}">«上一页</a>
											<a href="list?pageNow=${page.pageNow}">下一页»</a>
											<a href="list?pageNow=${page.totalPage}">尾页</a>
										</c:when>
										<c:otherwise>
											<a href="list?pageNow=1">首页</a>
											<a href="list?pageNow=${page.pageNow-1}">«上一页</a>
											<a href="list?pageNow=${page.pageNow+1}">下一页»</a>
											<a href="list?pageNow=${page.totalPage}">尾页</a>
										</c:otherwise>
									</c:choose>
								</c:if></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function doDeleteUser(name,id){
		var deleteConfirm=confirm("是否确认删除用户："+name+"?");
		if(deleteConfirm==true){
			document.location="delete?userModel.id="+id;
			alert("删除成功！");
		}
	}
	</script>
</body>

</html>