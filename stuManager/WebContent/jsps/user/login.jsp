<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学风管理登录平台</title>
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript">
function _change(){
	var img = document.getElementById("img");
	img.src="/stuManager/Image?a="+new Date().getTime();
}
function judge(){
	var flag = 	$("#idd").val();
	if(flag=="1"){
		$("form").attr("action","/stuManager/StuServlet");
	}
	if(flag=="2"){
		$("form").attr("action","/stuManager/TeacherServlet");
	}
	if(flag=="3"){
		$("form").attr("action","/stuManager/AdminServlet");
	}
}
</script>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">	
<link rel="stylesheet" type="text/css" href="../css/login.css">   
</head>
<body>
<a class="a globalLoginBtn">登录</a>
<div class="modal fade" id="loginModal" style="display:none;">
	
	<div class="modal-dialog modal-sm" style="width:540px;">
		<div class="modal-content" style="border:none;">
			<div class="col-left">
				
			</div>
			<div class="col-right">
				<div class="modal-header">
					<button type="button" id="login_close" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="loginModalLabel" style="font-size: 18px;">登录</h4>
				</div>
				<div class="modal-body">
					<section class="box-login v5-input-txt" id="box-login">
	<form action="/stuManager/jsps/hello.jsp" onsubmit="judge()" method="post">
	 	<table>
	 		<tr>
	 			<td colspan="3" style="color:red;">${msg}
	 				<input type="hidden" name="method" value="login">
	 			</td>
	 		</tr>
	 		<tr>
	 			<td><label for="user">用户名</label></td>
	 			<td><input  class="form-control" type="text" name="username" id="user"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="pwd">密&nbsp;&nbsp;码</label></td>
	 			<td><input class="form-control" type="text" name="pwd" id="pwd"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="idd">身&nbsp;&nbsp;份</label></td>
	 			<td>
	 				<select  class="form-control" id="idd" name="id">
	 					<option value="1">学生</option>
	 					<option value="2" >教师</option>
	 					<option value="3" >管理员</option>
	 				</select>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td><label for="veri">验证码</label></td>
	 			<td>
	 				<input  class="form-control" type="text" name="verifycode" id="veri">
	 			</td>
	 			<td>
	 				<img src="${pageContext.request.contextPath}/Image" id="img">
	 			</td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><a href="javascript:_change()">看不清，换一张</a></td>
	 			<td colspan="3" style="color:red;">${imgmsg}</td>
	 		</tr>
	 		<tr align="center">
	 			<td ><input class="btn btn-micv5 btn-block globalLogin" type="submit" value="登陆"></td>
	 		</tr>
	 	</table>
	 </form>
						<div class="threeLogin"><span>其他方式登录</span><a class="nqq" href="javascript:;"></a><a class="nwx" href="javascript:;"></a><!--<a class="nwb"></a>--></div>
						
					</section>
				</div>
			</div>
		</div>
	</div>
</div>		

<script type="text/javascript" src="../css/jquery2.2.2.min.js"></script>
<script type="text/javascript" src="../css/modal.js"></script>
<script type="text/javascript" src="../css/script.js"></script>
</body>
</html>