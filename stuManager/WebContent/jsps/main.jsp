<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="../images/xlogo.png" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学风管理平台</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="<c:url value="../jquery/jquery.js"/>"></script>
</head>
<body id="bg">

<div id="ct">
  <div class="system_lop">
   	<div class="system_lop_lop">
        	<img src="../images/content/logo.png" width="50" height="45" />
        </div>
    </div>
    <div class="system_lol">学风建设管理平台</div>
    <div class="system_lom" style="line-height:80px">
    	<span>欢迎${username}登陆系统</span>
    	&nbsp;&nbsp;
    	<span><a href="/stuManager/MissServlet">退出登录</a></span>
    </div>
</div>
<div id="container">
	<div class="leftsidebar_box">
		<div class="line"></div>
		<dl class="system_log">
			<dt>菜单列表</dt>
		</dl>
		<dl class="custom">
			<dt>信息管理<img src="../images/left/select_xl01.png"></dt>
			<c:if test="${id eq '3' || id eq '2'}">
				<dd><a href="/stuManager/AdminServlet?method=findAll" target="hoby">学生信息管理</a></dd>
			</c:if>
			<c:if test="${id eq '3'}">
				<dd class="first_dd"><a href="/stuManager/AdminServlet?method=findAllTeacher" target="hoby">教师信息管理</a></dd>
			</c:if>
		    <c:if test="${id eq '3'}">
				<dd><a href="/stuManager/AdminServlet?uid=${username}&method=find" target="hoby">个人信息管理</a></dd>
		    </c:if>
		     <c:if test="${id eq '2'}">
				<dd><a href="/stuManager/TeacherServlet?uid=${username}&method=findTea" target="hoby">个人信息管理</a></dd>
		    </c:if>
		     <c:if test="${id eq '1'}">
				<dd><a href="/stuManager/StuServlet?uid=${username}&method=findStu" target="hoby">个人信息管理</a></dd>
		    </c:if>
		</dl>
	
		<dl class="channel">
			<dt>基础管理<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="/stuManager/NoticeServlet?method=findAll" target="hoby">公告信息</a></dd>
		</dl>
      <dl class="channel">
			<dt>学生管理<img src="../images/left/select_xl01.png"></dt>
			<c:if test="${id eq '3'}">
				<dd class="first_dd"><a href="/stuManager/AwardServlet?method=findAlAward" target="hoby">奖学金管理</a></dd>
				<dd><a href="/stuManager/JudgeServlet?method=findAll" target="hoby">奖金评定管理</a></dd>
				<dd><a href="/stuManager/RecordServlet?method=findAll" target="hoby">档案管理</a></dd>
				<dd><a href="/stuManager/TitleServlet?method=findAll" target="hoby">荣誉称号管理</a></dd>
			</c:if>
			<c:if test="${id eq '2'}">
				<dd><a href="/stuManager/TitleServlet?method=findTitle&uid=${user}" target="hoby">荣誉称号</a></dd>
				<dd><a href="/stuManager/JudgeServlet?method=findAll" target="hoby">奖金评定管理</a></dd>
			</c:if>
			<c:if test="${id eq '1'}">
				<dd><a href="/stuManager/JudgeServlet?method=findJudge&uid=${user}" target="hoby">查看奖金</a></dd>
				<dd><a href="/stuManager/RecordServlet?method=findRecord&uid=${user}" target="hoby">查看档案</a></dd>
			</c:if>
			<!-- <dd><a href="#">处分管理</a></dd> -->
	  </dl>
  </div>
  <div id="comment_lop"><img src="/stuManager/images/left/home.png" width="15" height="13" /> 菜单列表</div>
  <div id="dashuju_bf">
  		<iframe width="100%" height="935px" frameborder="0" src="<c:url value='/jsps/hello.jsp'/>" name="hoby"></iframe>
  </div>
</div>

</body>
<script type="text/javascript" src="../jquery/jquery.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#3992d0"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","../images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>
</html>