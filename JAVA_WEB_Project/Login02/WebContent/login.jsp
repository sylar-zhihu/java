<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<style>
body {
	background-color: pink;
}

span {
	color: red;
}
</style>

<script type="text/javascript">
			// js代码
			function clearLoginMsg(){
				var spanEle = document.getElementById("login_span");
				spanEle.innerHTML ="";
			}
			
		</script>

<!-- <script type="text/javascript" src="引入一个js文件"></script> -->

</head>
<body bgcolor="pink">
	<h1>欢迎登录</h1>
	<!-- action: 请求的地址 -->
	<!-- method: 请求的方式    -->
	<!-- GET:将请求数据拼接到请求地址中， 直接暴露出来.  -->
	<!-- http://localhost:8888/web01/login?username=Admin&password=123456 -->
	<!-- POST:将请求数据存到请求体中提交，不会直接暴露出来。 -->
	<form action="login" method="post">
		用户名称:
		<input type="text" name="username" onfocus="clearLoginMsg();" />
		<!-- EL表达式默认会从 pageScope requestScope  sessionScope  applicationScope中查找数据 -->
		<span id="login_span">${requestScope.login_msg}</span>
		
		<%-- 不使用EL表达式
				<%
					// 获取到request对象:  request对象可以直接用。  
					String loginMsg = (String)request.getAttribute("login_msg");
				%>
				<span><%=loginMsg==null?"":loginMsg %></span>
			--%>
		<br />
		用户密码 :
		<input type="password" name="password" />
		<br />
		<input type="submit" value="Login" />

	</form>
</body>

</html>