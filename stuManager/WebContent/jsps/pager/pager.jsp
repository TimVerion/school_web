<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                 <input type="button" value="第${pb.pd }/共${pb.tp}页"> 
				    <a href="${pb.url}&pd=1"><input type="button" value="首页"></a>	
					<c:if test="${pb.pd > 1 }">
						<a href="${pb.url}&pd=${pb.pd - 1 }"><input type="button" value="上一页"></a>
					</c:if>
					<c:choose>
						<c:when test="${pb.tp < 5 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${pb.tp }"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin" value="${pb.pd-2}"></c:set>
							<c:set var="end" value="${pb.pd+2}"></c:set>	
							<c:if test="${begin<1}">
								<c:set var="begin" value="1"/>
					  		  <c:set var="end" value="5"/>
							</c:if>
							<c:if test="${end>pb.tp}">
								<c:set var="begin" value="${pb.tp-4}"/>
					   			 <c:set var="end" value="${pb.tp }"/>
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:forEach begin="${begin }" end="${end }" var="i">
						<c:choose>
							<c:when test="${i eq pb.pd }">
							<input type="reset" value="[${i}]">
							</c:when>
							<c:otherwise>
								<a href="${pb.url}&pd=${i}"><input type="reset" value="[${i}]"></a>
							</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:if test="${pb.pd < pb.tp }">
						<a href="${pb.url}&pd=${pb.pd + 1 }"><input type="button" value="下一页"></a>
					</c:if>
				    <a href="${pb.url}&pd=${pb.tp}"><input type="button" value="尾页"></a>	