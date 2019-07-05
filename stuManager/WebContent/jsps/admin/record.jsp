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
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="addItems2.do" enctype="multipart/form-data" >  <!-- enctype="multipart/form-data" -->
      <div class="form-group">
        <div class="label">
          <label>档案名称：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="name" class="input tips" />
        </div>
        </div>
     
      <div class="form-group">
        <div class="label">
          <label>学生：</label>
        </div>
        <div class="field">
        <select name="uid">
        <c:forEach items="${ulist }" var="k">
        <option value="${k.uid }">${k.tname }</option>
        </c:forEach>
        </select>
          <div id='checku' class="tips"></div>
        </div>
      </div>
      <div class="form-group">
         <div class="label">
          <label>档案上传：</label>
        </div>
        <div class="field">
          <input type="file" id="url1" name="file" class="input tips" style="width:25%; float:left;"  value="文件上传"  />
          <div class="tipss"></div>
        </div>
        </div>
         <div class="form-group">
          <div class="label">
            <label>档案备注：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
           <textarea rows="10" cols="80" name="note" id="editor_id" style="width:800px;height:200px;">
           </textarea>
          </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button type="submit" onclick="return checkAll()"> 提交</button>
        </div>
      </div>
     </form>
    </div>
   </div>
</body>
</html>