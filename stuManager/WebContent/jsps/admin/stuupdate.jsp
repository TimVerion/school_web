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
<script type="text/javascript" src="<c:url value="jquery/jquery.js"/>"></script>
<script type="text/javascript">
function change(file){
	   if(!file.files||!file.files[0]){
     return;
 }
 var reader = new FileReader();
 reader.onload = function(evt){
     document.getElementById('previewIm').src = evt.target.result;
     image = evt.target.result;
 }
 reader.readAsDataURL(file.files[0]);
}
</script>
<body>
<center>
<form action="/stuManager/UpdateStuServlet" enctype="multipart/form-data" method="post" id="form">
<table  width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" colspan="2" style="font-size:32px">更新内容</td>
  </tr>
  <tr>
    <td align="center" width="150px"> <label>用户名：</label></td>
    <td> 
    	<input type="text" value="${user.uid }" name="uid">
          <input type="hidden"  value="${user.id }" name="id" />
    </td>
  </tr>
  <tr>
    <td align="center"> <label>图片：</label></td>
    <td> <img alt="" src="<c:url value='/${user.img }'/>" width="100" height="100" id="previewIm">
          <input type="file" id="url1" name="file" class="input tips" style="width:25%; float:left;"  value="<%=application.getRealPath("\\images\\a_img") %>\\${user.img}" onchange="change(this)"  />
  		
  			
  	
  	    <span style="color:red;">${msg }</span>
          
          </td>
  </tr>
  <tr>
    <td align="center"><label>姓名：</label></td>
    <td><input type="text" id="url1" name="tname" class="input w50" value="${user.tname }" /></td>
  </tr>
   <tr>
    <td align="center"><label>性别：</label></td>
    <td>  <input type="text" id="url1" name="sex" class="input w50" value="${user.sex }" />
  </tr>
  <tr>
    <td align="center"><label>电话：</label></td>
    <td><input type="text" id="url1" name="tel" class="input w50" value="${user.tel }" /></td>
  </tr>
  <tr>
    <td align="center"><label>班级：</label></td>
    <td><input id="url1" type="text" class="input w50" value="${user.clazz }" name="clazz"  /></td>
  </tr>
  <tr>
    <td align="center"><label>地址：</label></td>
    <td><input type="text" id="url1" name="address" class="input w50" value="${user.address }" /></td>
  </tr>
  <tr>
    <td align="center"><label></label></td>
    <td> <button class="button bg-main icon-check-square-o" type="submit"> 提交</button></td>
  </tr>
</table>
</form>
</center>
</body>
</html>