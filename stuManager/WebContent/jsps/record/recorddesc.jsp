<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#url1{width: 250px;height: 26px; line-height: 26px;}
a { text-decoration:none; color:#4f4f4f;}
a:hover { text-decoration:underline; color:#F40; }
img{ border:0px; margin-bottom: -7px;}
table { ;border: 1px solid #B1CDE3; border-collapse: collapse;}
td,th {border: 1px solid #B1CDE3;background: #fff;font-size:14px;padding: 3px 3px 3px 8px;color: #4f6b72;height: 45px;}
input[type="submit"]{
width:90px;height:36px;border: 1px solid; border-color: #EEE #CCC #CCC #EEE;color: #000; font-weight: bold; background: #F5F5F5;
}
</style>
</head>
<script type="text/javascript" src="<c:url value="/jquery/jquery-1.5.1.js"/>"></script>


<script type="text/javascript">
$(function(){
	
	$(".ta").each(function(){
		var filer = $(this).parent().children("#in").val();
		var str=this;
		$.post("/stuManager/AServlet",{"filer":filer},function(msg){
			$(str).val(msg);
		},"text")
			
	})
	
})
</script>
<body>
<center>
<form action="/stuManager/AddRecordServlet" enctype="multipart/form-data" method="post" id="form">
<table  width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" colspan="2" style="font-size:32px">个人档案</td>
  </tr>
	<tr>
		<td>姓名</td>
		<td>${record.name }</td>
	</tr>
	<tr>
		<td>档案名称</td>
		<td>${record.tname}</td>
	</tr>
	<tr>
		<td>档案内容</td>
			 <td>
			 <input type="hidden" value="${record.filer }" id="in">
			 <textarea rows="8" cols="100" name="note" class="ta"></textarea>
			 </td>
	</tr>
	<tr>
		<td>发布时间</td>
		<td>${record.pubtime}</td>
	</tr>
  <!-- <tr>
    <td align="center"><label></label></td>
    <td> <button class="button bg-main icon-check-square-o" type="submit"> 添加</button></td>
  </tr> -->
</table>
</form>
</center>
</body>
</html> 