<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a { text-decoration:none; color:#4f4f4f;}
a:hover { text-decoration:underline; color:#F40; }
img{ border:0px;}
table {width:100% ;border: 1px solid #B1CDE3; border-collapse: collapse;}
td,th {border: 1px solid #B1CDE3;background: #fff;font-size:14px;padding: 3px 3px 3px 8px;color: #4f6b72;height: 45px;}
textarea{
border: 1px solid; border-color: #CCC #EEE #EEE #CCC;
background: #F5F5F5;
height: 200px;
width: 300px;
}
input{
border: 1px solid; border-color: #CCC #EEE #EEE #CCC;
background: #F5F5F5;
height: 32px;
width: 160px;
}
</style>
</head>
<script type="text/javascript" src="../jquery/jquery-1.5.1.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("/stuManager/AServlet",function(msg){
			alert(msg)
			$("#ta1").val(msg);
		},"text");
	})
</script>
<body>
<form>
输入内容：<input type="text" id="in1" onchange="change()">
<textarea rows="20" cols="20" id="ta1"></textarea>

</form>

</body>
</html>