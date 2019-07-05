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
<script type="text/javascript" src="<c:url value="/jquery/jquery.js"/>"></script>
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
<form action="/stuManager/AddTeacherServlet" enctype="multipart/form-data" method="post" id="form">
<table  width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" colspan="2" style="font-size:32px">添加</td>
  </tr>
  <tr>
    <td align="center" width="150px"> <label>用户名：</label></td>
    <td> 
          <input type="text" name="uid" />
    </td>
  </tr>
  <tr>
    <td align="center"> <label>图片：</label></td>
    <td> <img alt="" src="" width="100" height="100" id="previewIm">
          <input type="file" id="url1" name="file" class="input tips" style="width:25%; float:left;"  value=""  onchange="change(this)" />
           <span style="color:red;">${msg }</span>
          </td>
  		
  </tr>
  <tr>
    <td align="center"><label>姓名：</label></td>
    <td><input type="text" id="url1" name="tname" class="input w50"  /></td>
  </tr>
  <tr>
    <td align="center"><label>电话：</label></td>
    <td><input type="text" id="url1" name="tel" class="input w50"/></td>
  </tr>
   <tr>
    <td align="center"><label>性别：</label></td>
    <td>  <input type="text" id="url1" name="sex" class="input w50"/>
  </tr>
   <tr>
    <td align="center"><label>身份：</label></td>
    <td>  <input type="text" id="url1" name="utype" class="input w50"/>
  </tr>
  <tr>
    <td align="center"><label>地址：</label></td>
    <td><input type="text" id="url1" name="address" class="input w50"  /></td>
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