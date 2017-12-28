<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
    <body align="center">
  		<form style="margin-top:200px" action="<%=path %>/teacher/login.do" method="post">
  			姓名:<input name="name"/><br/>
  			密码:<input name="pwd" type="password"/><br/>
  			<input type="submit" value="登录"/>  <a href="<%=path %>/page/register.jsp"><input type="button" value="注册"/></a>
  		</form>
  </body>
</html>
