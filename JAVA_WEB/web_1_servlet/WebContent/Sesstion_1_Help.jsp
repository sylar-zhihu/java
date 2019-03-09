<%@ page language="java" import="java.util.*,java.util.Map.Entry;"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'shopping2.jsp' starting page</title>



</head>
<body>

	<%
	    HttpSession mySession = request.getSession(); %>
	<!-- 属性 -->
	获取属性
	<br>
	<%=mySession.getAttribute("key")%>
	<%
        // 对象
        Map<String, String> map = (Map<String, String>) mySession.getAttribute("map");
        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> entry : entrySet) {
            %>
	<br>
	<td>得到所有的key ：<%=entry.getKey()%></td>
	
	<%
        }
    %>

</body>
</html>
