<%@page import="com.ms.bean.Teacher"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		*{
			margin :0px;
			padding:0px;
		}
		body{
			color:white;
			text-align:center;
		}
		a{
			color:white;
			text-decoration-line:none;
		}
		.contain{
			width :100%;
			height:100%;
			border:1px solid;
			background:black;
		}
		.left{
			height:80%;
			width :20%;
			margin:30px;
			margin-right:0px;
			color :white;
			float :left;
		}
		.left ul{
			padding:30px;
			height:80%;
			width:30%;
			border:2px solid white;
		}
		.left ul li{
			margin-top:30px;
		}
		.right{
			height:80%;
			width :60%;
			margin:30px;
			color :white;
			float :left;
			border:2px solid white;
			background-color:white;
			margin-left:0px;
			color:black;
		}
		.tb{
			width:60%;
			text-align:center;
			border:1px solid black;
			margin:50px auto;
		}
		.tb td{
			border:1px solid black;
			color:black;
		}
	</style>
  </head>
  
  <body>
      <div class="contain">
      	<h1>学生管理系统</h1>
      	<div class="left">
      		<ul>
      			<a href="<%=path%>/teacher/toHome.do"><li>管理员列表</li></a>
      			<a href="<%=path%>/student/toStudentList.do"><li style="color:blue"><strong>学生列表</strong></li></a>
      			<a href="<%=path%>/student/toAddStudent.do"><li>学生添加</li></a>
      			<a href="<%=path%>/student/toAltStudent.do"><li>学生修改</li></a>
      			<a href="<%=path%>/student/toDelStudent.do"><li>学生删除</li></a>
      		</ul>
      	</div>
      	<div class="right">
      		<h3>学生列表</h3>
      		<table class="tb">
      			<tr>
	      			<thead>
	      				<td>学号</td>
	      				<td>姓名</td>
	      				<td>班级</td>
	      				<td>性别</td>
	      				<td>年龄</td>
	      			</thead>
      			</tr>
      			<c:if test="${not empty students }">
      				<c:forEach var="student" items="${students }" >
	      				<tr>
	      					<td><c:out value="${student.id }"/></td>
	      					<td><c:out value="${student.name }"/></td>
	      					<td><c:out value="${student.s_class }"/></td>
	      					<td><c:out value="${student.sex }"/></td>
	      					<td><c:out value="${student.age }"/></td>
	      				</tr>
      				</c:forEach>
      			</c:if>
      		</table>
      	</div>
      </div>
  </body>
  
</html>
