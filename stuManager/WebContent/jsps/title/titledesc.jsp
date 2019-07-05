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
	$.post("/stuManager/AdminServlet?method=findAlTea",function(list){
			for(var i = 0; i < list.length; i++){
				$("#id").append("<option value="+list[i].tname+">"+list[i].tname+"</option>");
			}
		},"json");
	
})
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
<form action="/stuManager/AddTitleServlet" enctype="multipart/form-data" method="post" id="form">
	<table>
		<tr>
			<td>姓名</td>
			<td>
				${title.tname }
			</td>
		</tr>
		 <tr>
   				 <td align="center"> <label>图片：</label></td>
   				<td><img alt="没有" src="<c:url value='/${n.img }'/>" width="50px" height="50px"></td>
        	   
  		
 		 </tr>
 		 <tr>
			<td>称号</td>
			<td>
				${title.name }
			</td>
		</tr>
		<tr>
			<td>发布时间</td>
			<td>
				${title.pubtime }
			</td>
		</tr>
		<!-- <tr><td colspan="2">
			<input type="submit" value="提交">
		</td></tr> -->
	</table>
</form>
</body>
</html>