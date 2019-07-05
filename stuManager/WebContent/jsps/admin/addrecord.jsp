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
$(function(){
		$.post("/stuManager/AdminServlet?method=findAlStu",function(list){
			alert(list);
			for(var i = 0; i < list.length; i++){
				$("#id1").append("<option value="+list[i].tname+">"+list[i].tname+"</option>");
			}
		},"json");
	
		$.post("/stuManager/AServlet",{"filer":"general.txt"},function(msg){
			
			$("#ta").val(msg);
		},"text");
	
})
</script>
<body>
<center>
<form action="/stuManager/AddRecordServlet" enctype="multipart/form-data" method="post" id="form">
<table  width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" colspan="2" style="font-size:32px">添加</td>
  </tr>
  <tr>
    <td align="center" width="150px"> <label>姓名</label></td>
    <td> 
          <select name="name" id="id1">
					<option value="">--请选择--</option>
				</select>
    </td>
  </tr>
  <tr>
    <td align="center"><label>档案名称：</label></td>
    <td><input type="text" name="tname"></td>
  </tr>
  <tr>
    <td align="center"> <label>文件：</label></td>
    <td> 
          <input type="file" id="url1" name="file" class="input tips" style="width:25%; float:left;"  value=""  />
    </td>
  		
  </tr>
  <tr>
    <td align="center"><label>备注：</label></td>
    <td><textarea rows="8" cols="20" name="note" id="ta"></textarea></td>
  </tr>
  <tr>
    <td align="center"><label>发布时间：</label></td>
    <td><input type="date" name="pubtime"></td>
  </tr>
  <tr>
    <td align="center"><label></label></td>
    <td> <button class="button bg-main icon-check-square-o" type="submit"> 添加</button></td>
  </tr>
</table>
</form>
</center>
</body>
</html>