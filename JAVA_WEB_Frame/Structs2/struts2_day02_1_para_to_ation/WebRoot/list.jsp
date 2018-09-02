<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/list" method="post">
		username1:<input type="text" name="users[0].username"><br>
		password1:<input type="password" name="users[0].password"><br>
		
		username2:<input type="text" name="users[1].username"><br>
		password2:<input type="password" name="users[1].password"><br>
		
		<input type="submit" value="登录">
	</form>
  </body>
</html>
