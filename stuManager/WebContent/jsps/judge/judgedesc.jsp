<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<c:url value="/jquery/jquery-1.5.1.js"/>"></script>
<script type="text/javascript">
$(function(){
	$.post("/stuManager/AdminServlet?method=findAlStu",function(list){
			for(var i = 0; i < list.length; i++){
				$("#id").append("<option value="+list[i].tname+">"+list[i].tname+"</option>");
			}
		},"json");
	$.post("/stuManager/AwardServlet?method=findAll",function(list){
		for(var i = 0; i < list.length; i++){
			$("#id2").append("<option value="+list[i].name+">"+list[i].name+"</option>");
		}
	},"json");
	
})

</script>
<body>
<form action="/stuManager/JudgeServlet?method=add" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" value="${judge.tname }">
			</td>
		</tr>
		<tr>
			<td>奖学金名称</td>
			<td>
			<input type="text" value="${judge.name }">
			</td>
		</tr>
		<tr>
			<td>奖学金等级</td>
			<td>
			<input type="text" value="${award.level }">
			</td>
		</tr>
		<tr>
			<td>奖学金额度</td>
			<td>
			<input type="text" value="${award.price }">
			</td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td>
				<input type="date" name="pubtime" value="${judge.pubtime }">
			</td>
		</tr>
		<!-- <tr><td colspan="2">
			<input type="submit" value="提交">
		</td></tr> -->
	</table>
</form>
</body>
</html>