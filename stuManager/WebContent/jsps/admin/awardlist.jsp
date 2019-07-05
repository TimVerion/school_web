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
input[type="button"]{
border: 1px solid; border-color: #EEE #CCC #CCC #EEE; width: 80px; height: 32px;
color: #000; font-weight: bold; background: #F5F5F5;
}
</style>
</head>
<script type="text/javascript" src="<c:url value="jquery/jquery.js"/>"></script>
<script type="text/javascript">
function del(id){
		$.post("AwardServlet?method=del",{"ids":id},function(flag){
			if(flag){
				alert("删除成功");
				location="AwardServlet?method=findAlAward";
			}else{
				alert("删除失败");
			}
			
		},"json");
}
function toUpdate(id){
	location="AwardServlet?method=findAward&id="+id;
}
function add(){
	location="jsps/admin/addaward.jsp";
}
</script>
<body>
<table>
	<tr>
		<td colspan="2"><input type="button" value="添加" onclick="add()"></td>
		<td colspan="4">奖金信息列表</td>
	</tr>
	<tr>
		<td>序号</td>
		<td>奖金名称</td>
		<td>等级</td>
		<td>奖金</td>
		<td>发布时间 </td>
		<td>操作</td>
	</tr>
	<c:forEach var="n" items="${list }" varStatus="count">
	<tr>
		<td>
			${count.index+1}
		</td>
		<td>${n.name }</td>
		<td>${n.level}</td>
		<td>${n.price }</td>
		<td>${n.pubtime }</td>
		<td>
			<input type="button" value="修改" onclick="toUpdate(${n.id})">
			<input type="button" value="删除" onclick="del(${n.id})">
		</td>
	</tr>
	
	</c:forEach>
</table>
</body>
</html>