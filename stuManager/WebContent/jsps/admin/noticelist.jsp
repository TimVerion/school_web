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
		$.post("NoticeServlet?method=del",{"ids":id},function(flag){
			if(flag){
				alert("删除成功");
				location="NoticeServlet?method=findAll";
			}else{
				alert("删除失败");
			}
			
		},"json");
}
function add(){
	location="jsps/admin/addnotice.jsp";
}
</script>
<body>
<table>
	<tr>
	<c:if test="${id eq '2' || id eq '3'}">
		<td colspan="4"><input type="button" value="添加" onclick="add()"></td>
	</c:if>
	<c:if test="${id eq '1'}">
		<td colspan="4" style="font-size: 32px">公告列表</td>
	</c:if>
	</tr>
	<c:forEach var="n" items="${pb.beanList }" varStatus="count">
	<tr>
		<td rowspan="3">照片</td>
		<td rowspan="3" width="250px"><img alt="没有" src="<c:url value='/${n.ggpic }'/>" width="150px" height="150px"></td>
		<td>序号</td>
		<td>
			${count.index+1}
		</td>
	</tr>
	<tr>
		<td>主题</td>
		<td>${n.name }</td>
	</tr>
	<tr>
		<td>内容</td>
		<td>${n.note}</td>
	</tr>
	<tr>
	<c:if test="${id eq '2' || id eq '3' }">
		<td colspan="3">
			<input type="button" value="删除" onclick="del(${n.ggid})">
		</td>
	</c:if>
	</tr>
	
	</c:forEach>
	<tr>
		<td colspan="7">
			<%@ include file="../pager/pager.jsp" %>
		</td>	
	</tr>
</table>
</body>
</html>