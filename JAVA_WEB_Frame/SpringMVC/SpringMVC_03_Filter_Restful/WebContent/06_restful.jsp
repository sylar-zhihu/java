<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<!-- 添加一个新的订单 -->
	<form action="order" method="post">
		<input type="submit" value="REST POST" />
	</form>

	<!-- 修改一个订单 -->
	<form action="order" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<input type="submit" value="REST PUT" />
	</form>
	<br />

	<br />
	<!-- 删除id为1001的订单 必须为post请求 -->
	<form action="order/1001" method="post">
		<!-- 隐藏域 转化为 DELETE-->
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="REST DELETE" />
	</form>
	<br />
	<!-- 查询id为1001的订单 -->
	<a href="order/1001">REST GET</a>
	<br />




</body>
</html>