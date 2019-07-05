<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/add.css">
</head>
<script type="text/javascript" src="<c:url value="/jquery/jquery-1.5.1.js"/>"></script>
<script type="text/javascript">

</script>
<body>
<form action="/stuManager/AwardServlet?method=add" method="post">
	<table>
		<tr>
			<td style="width: 200px">奖学金名称</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>等级</td>
			<td>
				<input type="text" name="level">
			</td>
		</tr>
		<tr>
			<td>奖金</td>
			<td>
				<input type="text" name="price">
			</td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td>
				<input type="date" name="pubtime">
			</td>
		</tr>
		<tr><td colspan="2">
			<input type="submit" value="提交">
		</td></tr>
	</table>
</form>
</body>
</html>