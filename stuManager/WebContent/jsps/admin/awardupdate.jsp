<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
td,th {text-align: center;border: 1px solid #B1CDE3;background: #fff;font-size:14px;padding: 3px 3px 3px 8px;color: #4f6b72;height: 45px;}
input[type="text"]{
border: 1px solid; border-color: #CCC #EEE #EEE #CCC;
background: #F5F5F5;
height: 32px;
width: 160px;
}
input[type="submit"]{
border: 1px solid; border-color: #EEE #CCC #CCC #EEE; width: 80px; height: 32px;
color: #000; font-weight: bold; background: #F5F5F5;
}
</style>
</head>
<script type="text/javascript" src="<c:url value="/jquery/jquery-1.5.1.js"/>"></script>
<script type="text/javascript">

</script>
<body>
<form action="/stuManager/AwardServlet?method=update" method="post">
	<table>
		<tr>
			<td>奖学金名称</td>
			<td>
				<input type="hidden" name="id" value="${user.id }">
				<input type="text" name="name" value="${user.name }">
			</td>
		</tr>
		<tr>
			<td>等级</td>
			<td>
				<input type="text" name="level" value="${user.level }">
			</td>
		</tr>
		<tr>
			<td>奖金</td>
			<td>
				<input type="text" name="price" value="${user.price }">
			</td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td>
				<input type="date" name="pubtime" value="${user.pubtime }">
			</td>
		</tr>
		<tr><td colspan="2">
			<input type="submit" value="提交">
		</td></tr>
	</table>
</form>
</body>
</html>