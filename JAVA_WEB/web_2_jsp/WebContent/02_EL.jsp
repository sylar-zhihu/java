<!-- JSP声明  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 文档类型 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- HTML -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My First Jsp Page</title>
	
	<style type="text/css">
		
		#d1{
			width:200px;
			height:200px;
			background-color:red ;
		}
	</style>
	
	
</head>
	<body>
	

		  
		  <!-- EL表达式的常用 -->
		  <br/>
		  ${1+1}
		  <br/>
<!-- 		  判断表达式 输出为false -->
		  ${2>3 }
		  <br/>
<!-- 		  判断是否为空 输出为true -->
		  ${empty a }
<!-- 		  判断非空 -->
		            ${!empty a }
		  
		  <br/>
		  
		  <input type="button" value="点我呀" onclick="clickButton();"/>
		  
		  <div id="d1" onmouseover="mouseOver();" onmouseout="mouseOut();"></div>
		  
		  <span id="s1">复杂的事情简单做，简单的事情重复做</span>
		  <br/>
		  <input id="i1" type="text"  name="msg" />
		  
		  <input type="button" id="d2" value="测试Jquery" />
		  
		  <br/>
		  <a href="CookieServlet">Test Cookie</a>
	</body>
</html>