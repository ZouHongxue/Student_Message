<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
  		<form style="margin-top:200px">
  			姓名:<input id="name"/><br/>
  			密码:<input id="pwd" type="password"/><br/>
  			<input type="reset" value="清空"/>  <input type="button" onclick="s()" value="注册"/>
  		</form>
  </body>
  <script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
  <script type="text/javascript">
  	 function s(){
  	 	$.ajax({
  	 		url:"<%=path%>/teacher/reg.do",
  	 		data:{
  	 			name:$("#name").val(),
  	 			pwd :$("#pwd").val(),
  	 		},
  	 		success:function(msg){
  	 			alert(msg);
  	 			if(msg=="注册成功")
  	 				window.location.href = "page/login.jsp";
  	 		}
  	 	})
  	 }
  </script>
</html>
