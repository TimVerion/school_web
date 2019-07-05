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
input[type="button"]{
border: 1px solid; border-color: #EEE #CCC #CCC #EEE; width: 80px; height: 32px;
color: #000; font-weight: bold; background: #F5F5F5;
}
input[type="reset"]{
border: 1px solid; border-color: #EEE #CCC #CCC #EEE; width: 30px; height: 32px;
color: #000; background: #F5F5F5;
}

</style>
</head>
<script type="text/javascript" src="<c:url value="jquery/jquery.js"/>"></script>
<script type="text/javascript">
function del(id){
		$.post("AdminServlet?method=delTea",{"ids":id},function(flag){
			if(flag){
				alert("删除成功");
				location="AdminServlet?method=findAllTeacher";
			}else{
				alert("删除失败");
			}
		},"json");
}
function toUpdate(id){
	location="AdminServlet?method=findTea&id="+id;
}
function add(){
	location="jsps/admin/addtea.jsp";
}
</script>
<body>
<form action="AdminServlet" action="get">
<table>
	<tr>
		<td colspan="4"><input type="button" value="添加" onclick="add()"></td>
		<td colspan="5">
				姓名：<input type="text" name="tname" placeholder="请输入要搜索的姓名">
				<input type="hidden" name="method" value="mohuTea">
				<input type="submit" value="搜索">
		</td>	
		
	</tr>
	<tr>
		<td>序号</td>
		<td>用户名</td>
		<td>图片</td>
		<td>姓名</td>
		<td>性别</td>
		<td>电话</td>
		<td>地址</td>
		<td>身份</td>
		<td>操作</td>
	</tr>
	<c:forEach var="n" items="${pb.beanList }" varStatus="count">
	<tr>
		<td>
			${count.index+1}
		</td>
		<td>${n.uid }</td>
		<td><img alt="没有" src="<c:url value='/${n.img }'/>" width="50px" height="50px"></td>
		<td>${n.tname}</td>
		<td>${n.sex }</td>
		<td>${n.tel }</td>
		<td>${n.address}</td>
		<td>${n.utype }</td>
		<td>
			<input type="button" value="修改" onclick="toUpdate(${n.id})">
			<input type="button" value="删除" onclick="del(${n.id})">
		</td>
	</tr>
	
	</c:forEach>
	<tr>
		<td colspan="9">
			<%@ include file="../pager/pager.jsp" %>
		</td>	
	</tr>
</table>
</form>
</body>
</html>