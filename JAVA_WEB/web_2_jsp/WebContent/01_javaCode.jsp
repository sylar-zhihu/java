<!-- JSP声明  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 文档类型 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- HTML -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My First Jsp Page</title>



</head>
<body>

	<h1 align="center">可以显示HTML代码</h1>
	<!-- java 片段 -->
	<%
		 	String str = "Abc";
		 	System.out.println("Abc");
		 %>

	<!-- 表达式 -->
	<%=5>3?"大于":"小于" %>


	<!-- jsp页面的执行原理: -->
	<!-- JSP本质上就是一个Servlet. 执行的时候会先在转化成一个.java文件，再编译成.class文件.  -->
	<!-- 如何转化:  -->
	<!-- java代码片段照搬 -->
	<!-- html、css、js、 表达式  通过输出流 out.writer()方法往出写.  -->
	<!-- 作用:  -->
	<!-- 1. 可以自动的将html相关的代码通过流写到浏览器端.  -->
	<!-- 2. 支持写java代码，可以灵活的做出一些处理.  -->


</body>
</html>