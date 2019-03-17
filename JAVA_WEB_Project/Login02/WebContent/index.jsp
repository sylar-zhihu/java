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
	
	
	<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"> </script>
	<script type="text/javascript">
		//定义函数
		function  clickButton(){
			//window.alert("是谁在点我.....");			
			var spanEle = window.document.getElementById("s1");
			
			var msg = spanEle.innerHTML;
			
			spanEle.innerHTML = "拼搏到无能为力，努力到不能自己.";
			
			document.getElementById("i1").value= msg;
			//alert(msg);
			
		}
		function  mouseOver(){
			//alert("鼠标进来了.....");
		}
		function  mouseOut(){
			alert("鼠标离开了.....")
		}
		
		
		$(function(){   // 相当于 window.onload();
			//alert("文档加载完毕了")
			// $("#d2")  就相当于  document.getElementById("d2");
			
			$("#d2").click(function(){  // 动态绑定事件
				var msg = $("#s1").html();
				//alert(msg);
				
				$("#i1").val(msg);
				
				
				//Jquery  --> Dom
				var Jobj  = $("#s1");
				var dObj = Jobj[0];  // Jobj.get(0)
				
				//Dom -->JQuery 
				
				var JJobj = $(dObj);
			});
		});
		
	</script>
	
	
</head>
	<body>
	
		  
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