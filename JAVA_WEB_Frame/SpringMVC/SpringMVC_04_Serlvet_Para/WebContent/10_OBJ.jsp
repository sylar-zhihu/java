<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 不使用中文 会乱码 使用对象接受参数 -->
	<form action="testOBJ" method="post">
		用户名称:
		<input type="text" name="username" />
		<br />
		用户密码:
		<input type="password" name="password" />
		<br />
		用户邮箱:
		<input type="text" name="email" />
		<br />
		用户性别: 男
		<input type="radio" name="gender" value="1" />
		女
		<input type="radio" name="gender" value="0" />
		<br />
		<!-- 支持级联的方式 -->
		用户省份:
		<input type="text" name="address.province" />
		<br />
		用户城市:
		<input type="text" name="address.city" />
		<br />
		<input type="submit" value="注册" />
	</form>
	<br />
</body>
</html>